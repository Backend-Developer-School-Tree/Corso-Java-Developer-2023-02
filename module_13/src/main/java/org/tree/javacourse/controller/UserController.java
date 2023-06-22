package org.tree.javacourse.controller;

import com.google.gson.Gson;
import org.tree.javacourse.controller.response.HttpResponse;
import org.tree.javacourse.model.User;
import org.tree.javacourse.service.UserService;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.delete;
import static spark.Spark.put;

public class UserController {

    public void startServices(UserService userService) {

        //heartbit
        get("/", (req, res) -> "System is working!");

        get("/user/all", (req, res) -> {
            res.type("application/json");

            HttpResponse response = new HttpResponse("200",
                    new Gson().toJsonTree(userService.getAll()));

            return new Gson().toJson(response);
        });

        post("/user", (req, res) -> {
            res.type("application/json");

            User userFromPostRequest = new Gson().fromJson(req.body(), User.class);
            userService.insert(userFromPostRequest);

            return new Gson().toJson(new HttpResponse("200"));

        });

        put("/user", (req, res) -> {
            res.type("application/json");

            User userFromPostRequest = new Gson().fromJson(req.body(), User.class);
            userService.update(userFromPostRequest);

            return new Gson().toJson(new HttpResponse("200"));

        });

        delete("/user/:id", (req, res) -> {
            res.type("application/json");

            String paramID = req.params("id");
            userService.delete(Integer.valueOf(paramID));

            return new Gson().toJson(new HttpResponse("200"));
        });
    }
}
