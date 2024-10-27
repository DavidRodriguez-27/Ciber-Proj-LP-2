package com.cibertec.proyectogrupo4.controller;

import com.cibertec.proyectogrupo4.model.Pedidos;
import com.cibertec.proyectogrupo4.model.Platos;
import com.cibertec.proyectogrupo4.service.PedidosService;
import com.cibertec.proyectogrupo4.service.PlatosService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pedidos")
@AllArgsConstructor
public class PedidosController {

    private final PedidosService pedidosService;
    private final PlatosService platosService;
    private final EntityManager entityManager;

    @GetMapping("/listarPedidos")
    public String verPaginaInicio(Model model){
        model.addAttribute("listaPedidos", pedidosService.listarPedidos());
        return "pedidos/pedidos";
    }

    @GetMapping("/nuevoPedido")
    public String nuevoPedido(Model model){
        model.addAttribute("pedido", new Pedidos());
        return "pedidos/nuevoPedido";
    }

    @PostMapping("/guardarPedido")
    public String guardarPedido(@ModelAttribute("pedido") Pedidos pedido){

        String nombrePlato = pedido.getPlato().getNombre_plato();
        Platos platoExistente = platosService.obtenerPlatosPorId(pedido.getPlato().getId_plato());

        if (platoExistente != null) {
            pedido.setPlato(platoExistente);
        } else {
            Platos nuevoPlato = new Platos();
            nuevoPlato.setNombre_plato(nombrePlato);
            platosService.guardarPlato(nuevoPlato);
            pedido.setPlato(nuevoPlato);
        }
        pedidosService.guardarPedido(pedido);
        return "redirect:/pedidos/listarPedidos";
    }

    @GetMapping("/actualizarPedido/{id}")
    public String actualizarPedido(@PathVariable("id") Integer id, Model model){
        model.addAttribute("pedido", pedidosService.obtenerPedido(id));
        return "pedidos/actualizarPedido";
    }

    @GetMapping("/eliminarPedido/{id}")
    public String elimarPedido(@PathVariable("id") Integer id){
        pedidosService.eliminarPedido(id);
        return "redirect:/pedidos/listarPedidos";
    }

    @GetMapping("/reportePedidos")
    public void reportePedidos(HttpServletResponse response) throws JRException, SQLException, IOException {
        // Obtén la conexión JDBC desde el EntityManager
        Session session = entityManager.unwrap(Session.class);
        Connection conn = session.doReturningWork(connection -> connection.unwrap(Connection.class));

        // Cargar el reporte .jasper
        InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/rptPedidos.jasper");
        Map<String, Object> params = new HashMap<>();

        // Cargar el reporte
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);

        // Llenar el reporte con la conexión JDBC obtenida
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);

        // Configuración para devolver el reporte PDF en la respuesta HTTP
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=productos_report.pdf");

        // Enviar el reporte como respuesta
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

        // Cerrar la conexión
        conn.close();
    }

}
