package no.hvl.dat110.messaging;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		if (payload.length <= 127) {
			this.payload = payload;
		} else {
			this.payload = null;
		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}

	public byte[] encapsulate() {
		byte[] encoded;
		encoded = new byte[128];
		encoded[0] = (byte) payload.length;
		for (int i = 1; i <= payload.length; i++) {
			encoded[i] = payload[i - 1];
		}
		return encoded;

	}

	public void decapsulate(byte[] received) {
		payload = new byte[received[0]];
		for (int i = 1; i <= received[0]; i++) {
			payload[i - 1] = received[i];
		}
	}
}
