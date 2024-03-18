package Network;

public class Neuron {
	public double[] input;
	public double[] weights;
	
	public Neuron(double[] input) {
		this.input = input;
		// Each Index of Input will have a corresponding Weight
		// The Connects to a Corresponding Neuron in the hidden layer.
		for (int i = 0; i < input.length; i++) {
			weights[i] = input[i] * 2;
		}
	}
}
