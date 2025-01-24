package org.example.backend.Servicio;

import org.example.backend.Repositorio.IGenericoRepositorio;

import java.util.List;

//Clase Crud Generico para servicio
public abstract class CRUD<T,ID> implements ICRUD<T,ID> {
    protected abstract IGenericoRepositorio<T,ID> getRepo();


    @Override
    public List<T> obtener() {
        return getRepo().findAll();
    }

    @Override
    public T insertar(T t) {
        return getRepo().save(t);
    }

    @Override
    public T actualizar(T t){
        return getRepo().save(t);
    }

    @Override
    public T obtenerUno(ID id){
        return getRepo().findById(id).orElse(null);

    }



    @Override
    public void eliminar(ID id){
        getRepo().deleteById(id);
    }


}
