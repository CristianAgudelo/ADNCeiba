package com.ceiba.usuario.consulta;

import java.util.List;

import com.ceiba.usuario.puerto.dao.DaoUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

@Component
@RequiredArgsConstructor
public class ManejadorListarUsuarios {

    private final DaoUsuario daoUsuario;

    public List<DtoUsuario> ejecutar(){ return daoUsuario.listar(); }
}
