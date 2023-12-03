package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.displayingLabels.DisplayingLabelsController;
import interface_adapter.displayingLabels.DisplayingLabelsPresenter;
import interface_adapter.displayingLabels.DisplayingLabelsViewModel;
import use_case.displayingLabels.DisplayingLabelsInputBoundary;
import use_case.displayingLabels.DisplayingLabelsInteractor;
import use_case.displayingLabels.DisplayingLabelsOutputBoundary;
import use_case.displayingLabels.DisplayingLabelsUserDataAccessInterface;
import view.LoggedInView;

    public class LoggedInUseCaseFactory {
        private LoggedInUseCaseFactory() {}

        /**
         * This method creates a Logged view that displays a menu from which you can choose whether you want to search
         * for new locations, view your planner or log out
         *
         * @param viewManagerModel this is the view manager model that is needed to create both the controller
         * @param displayingLabelsViewModel this is the ViewModel that is specific to the displayingLabels use case and
         *                                  is needed to create the Location view as well as the displaying labels
         *                                  controller
         * @param userDataAccessInterface this is the data access interface that is used by the displaying labels use
         *                                case and is required to create that use cases' controller
         * @return a Logged in view
         */
        public static LoggedInView create(ViewManagerModel viewManagerModel,
                                          DisplayingLabelsViewModel displayingLabelsViewModel,
                                          DisplayingLabelsUserDataAccessInterface userDataAccessInterface) {
            DisplayingLabelsController displayingLabelsController =
                    createLabels(viewManagerModel, displayingLabelsViewModel, userDataAccessInterface);
            return new LoggedInView(displayingLabelsController);
        }

        private static DisplayingLabelsController createLabels(ViewManagerModel viewManagerModel,
                                                               DisplayingLabelsViewModel displayingLabelsViewModel,
                                                               DisplayingLabelsUserDataAccessInterface userDataAccessInterface) {
            DisplayingLabelsOutputBoundary displayingLabelsOutputBoundary = new DisplayingLabelsPresenter(displayingLabelsViewModel, viewManagerModel);
            DisplayingLabelsInputBoundary displayingLabelsInputBoundary = new DisplayingLabelsInteractor(userDataAccessInterface, displayingLabelsOutputBoundary);
            return new DisplayingLabelsController(displayingLabelsInputBoundary);
        }
    }


