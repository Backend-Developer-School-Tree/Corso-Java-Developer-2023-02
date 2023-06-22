package org.tree.javacourse;

import org.tree.javacourse.controller.UserController;
import org.tree.javacourse.service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );

        //TODO: Implementare come Singleton
        UserService userService = new UserService();

        UserController userController = new UserController();
        userController.startServices(userService);
    }
}
