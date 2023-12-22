package com.feltac.weapi.ejb;

import java.util.List;

import com.feltac.weapi.dao.WeaponDao;
import com.feltac.weapi.model.Weapon;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@RequestScoped
public class WeaponBean {
    @Inject
    private WeaponDao weaponDao;

    public List<Weapon> retrieveAllWeapons()
    {        
        return weaponDao.getAll();
    }

    public Weapon retrieveOneWeapon(int id)
    {
        return weaponDao.getOne(id);
    }

    @Transactional
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
