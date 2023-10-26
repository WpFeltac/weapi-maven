package com.feltac.weapi.ejb;

import java.util.List;
import java.util.Optional;

import com.feltac.weapi.dao.WeaponDao;
import com.feltac.weapi.model.Weapon;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class WeaponBean {
    @Inject
    private WeaponDao weaponDao;

    public List<Weapon> retrieveAllWeapons()
    {
        return weaponDao.getAll();
    }

    public Optional<Weapon> retrieveOneWeapon(String weaponName)
    {
        return weaponDao.getOne(weaponName);
    }

    public Boolean createWeapon(Weapon weapon)
    {
        if(existsByName(weapon.getName()))
        {            
            return false;
        }

        weaponDao.add(weapon);
        return true;
    }

    public Boolean deleteWeaponByName(String weaponName)
    {
        if (!existsByName(weaponName)) 
        {
            return false;
        }

        weaponDao.delete(weaponName);
        return true;
    }

    public Boolean existsByName(String weaponName)
    {
        return weaponDao.existsByName(weaponName);
    }
}
