package com.feltac.weapi.servlet;

import java.io.IOException;
import java.util.List;

import com.feltac.weapi.ejb.WeaponBean;
import com.feltac.weapi.model.Weapon;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/weapons")
public class WeaponServlet extends HttpServlet {

    @Inject
    WeaponBean weaponService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Weapon> weapons = weaponService.retrieveAllWeapons();
        req.setAttribute("weaponList", weapons);
        req.setAttribute("test", 10);
        req.getRequestDispatcher("/WEB-INF/weapons.jsp").forward(req, resp);
    }

}