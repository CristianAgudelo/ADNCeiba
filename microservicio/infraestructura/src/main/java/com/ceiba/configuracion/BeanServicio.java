package com.ceiba.configuracion;

import com.ceiba.asesoria.puerto.dao.DaoAsesoria;
import com.ceiba.asesoria.puerto.repositorio.RepositorioAsesoria;
import com.ceiba.asesoria.servicio.ServicioActualizarAsesoria;
import com.ceiba.asesoria.servicio.ServicioCrearAsesoria;
import com.ceiba.asesoria.servicio.ServicioEliminarAsesoria;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario,
                                                           DaoAsesoria daoAsesoria,
                                                           DaoUsuario daoUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario, daoAsesoria, daoUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarAsesoria servicioEliminarAsesoria(RepositorioAsesoria repositorioAsesoria) {
        return new ServicioEliminarAsesoria(repositorioAsesoria);
    }

    @Bean
    public ServicioActualizarAsesoria servicioActualizarAsesoria(RepositorioAsesoria repositorioAsesoria,
                                                                 DaoAsesoria daoAsesoria,
                                                                 RepositorioUsuario repositorioUsuario,
                                                                 DaoUsuario daoUsuario) {
        return new ServicioActualizarAsesoria(repositorioAsesoria, daoAsesoria, repositorioUsuario, daoUsuario);
    }

    @Bean
    public ServicioCrearAsesoria servicioCrearAsesoria(RepositorioAsesoria repositorioAsesoria,
                                                       DaoAsesoria daoAsesoria,
                                                       RepositorioUsuario repositorioUsuario, DaoUsuario daoUsuario) {
        return new ServicioCrearAsesoria(repositorioAsesoria, daoAsesoria, repositorioUsuario,daoUsuario);
    }
}
