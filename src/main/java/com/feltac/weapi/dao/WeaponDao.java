package com.feltac.weapi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.feltac.weapi.model.Weapon;

import jakarta.enterprise.context.RequestScoped;

// DAO : Data Access Object (Repository)
@RequestScoped // -> Ajoute la classe dans le système de DI
public class WeaponDao {
    public static List<Weapon> weapons = new ArrayList<Weapon>();

    public void add(Weapon weapon) {
        weapons.add(weapon);
    }

    public List<Weapon> getAll() {
        return weapons;
    }

    public Optional<Weapon> getOne(String name) {
        return weapons.stream().filter((w) -> w.getName().equals(name)).findFirst();
    }

    public Boolean existsByName(String name)
    {
        return weapons.stream().filter((w) -> w.getName().equals(name)).findFirst().isPresent();
    }

    public void delete(String weaponName) 
    {
        weapons.removeIf((w) -> w.getName().equals(weaponName));
    }
}