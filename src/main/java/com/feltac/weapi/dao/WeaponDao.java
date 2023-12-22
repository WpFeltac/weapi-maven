package com.feltac.weapi.dao;

import java.util.ArrayList;
import java.util.List;

import com.feltac.weapi.model.Weapon;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

// DAO : Data Access Object (Repository)
@RequestScoped // -> Ajoute la classe dans le système de DI
public class WeaponDao {
    @PersistenceContext(name = "jqmk3105_weapi")
    private EntityManager entityManager;

    public static List<Weapon> weapons = new ArrayList<Weapon>();


    public List<Weapon> getAll() {
        return entityManager.createQuery("SELECT w FROM Weapon w", Weapon.class).getResultList();
    }

    public Weapon getOne(int id) {
        return entityManager.find(Weapon.class, id);
    }

    public void add(Weapon weapon) {
        entityManager.persist(weapon);
        entityManager.flush();
    }    

    public void delete(String weaponName) 
    {
        weapons.removeIf((w) -> w.getName().equals(weaponName));
    }

    public Boolean existsByName(String name)
    {
        return weapons.stream().filter((w) -> w.getName().toUpperCase().equals(name.toUpperCase())).findFirst().isPresent();
    }
}