/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.util.StringUtil;
import java.util.List;

/**
 *
 * @author mealf
 */
public class CursoService implements CursoIService {
    private final CursoIDao cursoDao;

    public CursoService(CursoIDao cursoDao) {
        this.cursoDao = cursoDao;
    }
    
    @Override
    public void save(Curso curso) {
        if (StringUtil.isEmpty(curso.getNome())){
            throw new RuntimeException("O nome do curso não pode estar vazio!");
        }
        cursoDao.save(curso);
    }

    @Override
    public void update(Curso curso) {
        cursoDao.update(curso);
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            Curso curso = new Curso();
            curso.setId(id);
            
            cursoDao.delete(curso);
        } catch (Exception e) {
            throw new Exception("Erro técnico ao remover: " + e.getMessage());
        }
    }

    @Override
    public List<Curso> findAll() {
        return cursoDao.findAll();
    }

    @Override
    public List<Curso> findByNomeOrDescricao(String termo) {
        return cursoDao.findByNomeOrDescricao(termo);
    }
    
    @Override
    public List<Curso> findByText(String termo) throws Exception {
        if (termo.length() < 2) {
            return cursoDao.findAll(); 
        }
        return cursoDao.findByNomeOrDescricao(termo);
    }
}
