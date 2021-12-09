/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.org.adra_estudio.ADRA.service;

import pe.org.adra_estudio.ADRA.entity.Usuario;

/**
 *
 * @author lober
 */
public interface UsuarioService {
    
    // buscar por email
    public Usuario findByEmail(int email);
    

}
