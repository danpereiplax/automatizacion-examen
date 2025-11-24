package cl.iplacex.automatizacion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    void sumaBasicaDebeSerCorrecta() {
        CalculadoraServicio svc = new CalculadoraServicio();
        int resultado = svc.sumar(2, 3);
        Assertions.assertEquals(5, resultado);
    }
}
