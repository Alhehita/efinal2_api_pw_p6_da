package com.example.efinal1_api_pw_p6_da.repository;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.stereotype.Repository;

import com.example.efinal1_api_pw_p6_da.repository.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Vehiculo vehiculo) {
        this.entityManager.persist(vehiculo);
    }

    @Override
    public Vehiculo seleccionarPorPlaca(String placa) {
        TypedQuery<Vehiculo> query = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa =:placa", Vehiculo.class);
        query.setParameter("placa", placa);
        if(placa != null){
            return query.getSingleResult();
        }
        else{
            return null;
        }
         
    }

    @Override
    public List<Vehiculo> seleccionarTodos() {
        TypedQuery<Vehiculo>  query = this.entityManager.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class);
        return query.getResultList();
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.entityManager.find(Vehiculo.class, id));
    }


    
}
