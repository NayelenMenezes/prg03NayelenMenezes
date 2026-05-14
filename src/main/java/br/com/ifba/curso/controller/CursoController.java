/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import java.util.List;

/**
 *
 * @author mealf
 */
public class CursoController implements CursoIController {
    private final CursoIService cursoService;

    public CursoController(CursoIService cursoService) {
        this.cursoService = cursoService;
    }
    
    @Override
    public void save(Curso curso) {
       cursoService.save(curso);
    }

    @Override
    public void update(Curso curso) {
       cursoService.update(curso);
    }

    @Override
    public void delete(Long id) throws Exception {
        this.cursoService.delete(id);
    }

    @Override
    public List<Curso> findAll() {
        return cursoService.findAll();
    }

    @Override
    public List<Curso> findByNomeOrDescricao(String termo) {
        return cursoService.findByNomeOrDescricao(termo);
    }
    
    @Override
    public List<Curso> findByText(String termo) throws Exception {
        return this.cursoService.findByText(termo);
    }
}
