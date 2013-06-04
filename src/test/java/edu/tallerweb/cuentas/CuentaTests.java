package edu.tallerweb.cuentas;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ago
 * 
 */
public class CuentaTests {

	@Test
	public void queCuentaSueldoVerifiqueLaConsigna() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(4000.0);

		Assert.assertEquals(
				"al depositar $ 4000.0 en una cuenta vacía, tiene $ 4000.0",
				4000.0, cuenta.getSaldo(), 0.0);

		cuenta.extraer(500.0);

		Assert.assertEquals(
				"al extraer $ 500.0 de una cuenta con $ 4000.0 se obtienen $ 3500.0",
				3500.0, cuenta.getSaldo(), 0.0);
	}

	@Test(expected = CuentaBancariaException.class)
	public void queCuentaSueldoNoPermitaExtraerEnNegativo() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(2000.0);
		cuenta.extraer(-1000.0);
	}

	@Test(expected = CuentaBancariaException.class)
	public void queVerifiqueLaConsignaException() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(3500.0);

		cuenta.extraer(4000.0);
	}

	@Test
	public void queCajaAhorrosVerifiqueLaConsigna() {
		CajaAhorros cuenta = new CajaAhorros();
		cuenta.depositar(4000.0);

		Assert.assertEquals(
				"al depositar $ 4000.0 en una cuenta vacía, tiene $ 4000.0",
				4000.0, cuenta.getSaldo(), 0.0);

		cuenta.extraer(500.0);

		Assert.assertEquals(
				"al extraer $ 500.0 de una cuenta con $ 4000.0 se obtienen $ 3500.0",
				3500.0, cuenta.getSaldo(), 0.0);

		cuenta.extraer(50.0);
		cuenta.extraer(50.0);
		cuenta.extraer(50.0);
		cuenta.extraer(50.0);

		Assert.assertEquals(
				"al extraer $ 200.0 de una cuenta en 4 veces con $ 3500.0 se obtienen $ 3300.0",
				3300.0, cuenta.getSaldo(), 0.0);

		cuenta.extraer(50.0);
		Assert.assertEquals(
				"al extraer por sexta vez $ 50.0 de una cuenta con $ 3300.0 se obtienen $ 3244.0",
				3244.0, cuenta.getSaldo(), 0.0);
	}

	@Test(expected = CuentaBancariaException.class)
	public void queCajaAhorrosVerifiqueLaConsignaException() {
		CajaAhorros cuenta = new CajaAhorros();
		cuenta.depositar(3500.0);

		cuenta.extraer(4000.0);
	}

	@Test
	public void queSePuedaDepositarEnCuentaCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente(1500.0);
		cuenta.depositar(4000.0);

		Assert.assertEquals(
				"al depositar $ 4000.0 en una cuenta vacia, tiene $ 4000.0",
				4000.0, cuenta.getSaldo(), 0.0);

	}

	@Test
	public void queSePuedaExtraerEnCuentaCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente(1500.0);
		cuenta.depositar(4000.0);

		cuenta.extraer(4500.0);

		Assert.assertEquals(
				"al extraer $ 4500.0 de una cuenta con $ 4000.0 se obtiene un saldo de $ 0.0",
				0.0, cuenta.getSaldo(), 0.0);
	}

	@Test
	public void queSeObtengaElDescubiertoDeCuentaCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente(1500.0);

		cuenta.depositar(4000.0);

		cuenta.extraer(4500.0);

		Double descubierto;
		descubierto = cuenta.getDescubierto();
		Assert.assertEquals(
				"al extraer $ 4500.0 de una cuenta con $ 4000.0 se obtienen un descubierto disponible de $ 975.0",
				975.0, descubierto, 0.0);
	}

	@Test(expected = CuentaBancariaException.class)
	public void queNoSePuedaRetirarMasQueElDescubiertoDisponibleMasElSaldoException() {
		CuentaCorriente cuenta = new CuentaCorriente(2000.0);
		cuenta.depositar(3500.0);

		cuenta.extraer(7000.0);

	}

	@Test(expected = CuentaBancariaException.class)
	public void queNoSePuedaRetirarUnaCantidadNegativaEnUnaCuentaCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente(2000.0);
		cuenta.depositar(3500.0);

		cuenta.extraer(-7000.0);

	}

}
