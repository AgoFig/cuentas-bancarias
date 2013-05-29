package edu.tallerweb.cuentas;

public class CuentaCorriente extends AbstractCuenta {

	private Double saldo;
	private Double descubiertoMaximo;
	private Double descubiertoUtilizado;
	private Double recargo;

	public CuentaCorriente(final Double descubiertoTotal) {
		this.saldo = 0.0;
		this.descubiertoMaximo = descubiertoTotal;
		this.descubiertoUtilizado = 0.0;
	}

	public void depositar(final Double monto) {

		if (monto > this.descubiertoUtilizado) {
			this.saldo += monto;
		} else {
			throw new RuntimeException(
					"El monto a depositar es menor al descubierto actual");
		}

	}

	public void extraer(final Double monto) {
		Double totalExtraccion;
		Double totalDisponible;

		totalExtraccion = monto + (monto * recargo);

		totalDisponible = this.descubiertoMaximo + this.saldo;
		if (monto <= saldo || monto >= 0.0) {
			this.saldo -= monto;
		} else {
			if (monto <= totalDisponible) {
				this.saldo -= totalExtraccion;
			} else {
				throw new CuentaBancariaException(
						"Esta intentando extraer mas alla del descubierto autorizado o un saldo negativo");
			}
		}

	}

	public Double getSaldo() {
		return this.saldo;
	}

	public Double getDescubierto() {
		return this.descubiertoUtilizado;
	}

}
