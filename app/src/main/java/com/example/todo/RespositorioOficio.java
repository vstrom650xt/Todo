package com.example.todo;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RespositorioOficio implements Serializable {

    private List<Oficio> repo;
    private static RespositorioOficio instance;


    public RespositorioOficio() {
        repo = new ArrayList<>();

        repo.add(new Oficio("jose1", 23));
        repo.add(new Oficio("jose1", 23));
        repo.add(new Oficio("jose1", 23));
        repo.add(new Oficio("jose1", 23));
        repo.add(new Oficio("jose1", 23));
        repo.add(new Oficio("jose1", 23));



    }


    public static RespositorioOficio getInstance(){
        if (instance == null)
            instance = new RespositorioOficio();

        return instance;
    }


    public int size(){return  repo.size();}
    public  List<Oficio> getAll(){return repo;}
    public  List<Oficio> addOficio(Oficio oficio){
        repo.add(oficio);


        return repo;}

    public Oficio getOficio(int i ){
      Oficio o =  repo.get(i);
    return o;
    }


}
