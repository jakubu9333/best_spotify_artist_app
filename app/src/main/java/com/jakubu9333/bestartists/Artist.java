package com.jakubu9333.bestartists;

import com.jakubu9333.bestartists.database.ArtistEntity;

import java.util.ArrayList;

/**
 * @author Jakub Uhlarik
 */
public class Artist {
    public Artist(String name){
        this.name=name;
    }

    private String name;
    private String uri="xd";
    private ArrayList<Image> images;
    private String url640="xd";
    private String url320;
    private String url160;
    private Boolean chosen = false;

    public String getName() {
        return name;
    }

    public ArtistEntity toEntity(){
        return new ArtistEntity(uri,name,url640);
    }
}
