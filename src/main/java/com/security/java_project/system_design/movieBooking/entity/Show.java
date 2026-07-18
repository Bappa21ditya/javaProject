package com.security.java_project.system_design.movieBooking.entity;

public class Show {

    public int id;
    public Movie movie;
    public Screen screen;

    public Show(int id,Movie movie,Screen screen)
    {
        this.id=id;
        this.movie=movie;
        this.screen=screen;
    }

}
