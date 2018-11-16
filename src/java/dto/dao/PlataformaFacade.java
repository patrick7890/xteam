/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.dao;

import dto.entidad.Plataforma;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Patricio
 */
@Stateless
public class PlataformaFacade extends AbstractFacade<Plataforma> {

    @PersistenceContext(unitName = "xteamPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlataformaFacade() {
        super(Plataforma.class);
    }
    
}