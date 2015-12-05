package code2;
public class Shipping {
	private double totalWeight;
	private double shippingFee;
	private boolean registered;
	private boolean express;

	public Shipping() {
		this.express = false;
		this.registered = false;
		this.shippingFee = 0.0;
		this.totalWeight = 0.0;
	}

	public Shipping(double totalWeight, boolean registered, boolean express) {
		this.totalWeight = totalWeight;
		this.registered = registered;
		this.express = express;
		calculateShippingFee();
	}

	public void calculateShippingFee() {
		if (Math.round(this.totalWeight) <= 1) {
			this.shippingFee += 20;
		} else {
			this.shippingFee += 15;
		}
		if (registered == true) {
			if (Math.round(this.totalWeight) < 5 && Math.round(this.totalWeight) > 0) {
				this.shippingFee += 22;
			} else if (Math.round(this.totalWeight) >= 5 && Math.round(this.totalWeight) < 10) {
				this.shippingFee += 38;
			} else {
				this.shippingFee += 58;
			}
		}
		if (express == true) {
			if (Math.round(this.totalWeight) < 0.5 && Math.round(this.totalWeight) > 0) {
				this.shippingFee += 50;
			} else if (Math.round(this.totalWeight) >= 0.5 && Math.round(this.totalWeight) < 2.5) {
				this.shippingFee += 100;
			} else if(Math.round(this.totalWeight) >= 2.5 &&Math.round(this.totalWeight)  < 5){
				this.shippingFee += 200;
			}else{
				this.shippingFee += 500;
			}
		}

	}

	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public double getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(double shippingFee) {
		this.shippingFee = shippingFee;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	public boolean isExpress() {
		return express;
	}

	public void setExpress(boolean express) {
		this.express = express;
	}

	@Override
	public String toString() {
		return "Totalweight = %.3f"+this.totalWeight+", Registered mail = "+this.registered
				+", Express mail = "+this.express+",Shipping fee = %.2f Baht"+this.shippingFee;
	}
}
