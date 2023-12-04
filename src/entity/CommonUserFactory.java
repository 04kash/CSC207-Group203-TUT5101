package entity;

public class CommonUserFactory implements UserFactory{
    /**
     * This method creates a Common User object by taking in a username, password and planner object
     *
     * @param name a string representing the users' username
     * @param password a string representing the users' password
     * @param planner a planner object in which all the users saved locations and labels are stored
     * @return a user object that contains all the information passed into creating it
     */
    @Override
    public User create(String name, String password, Planner planner) {
        return new CommonUser(name, password, planner);
    }
}
