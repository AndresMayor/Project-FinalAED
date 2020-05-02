package structures;

	public class Duplex< V, U> {
		
		
		private V e1;
		
		private U e2;
		
		
		public Duplex(V v, U u) {
			e1 = v;
			e2 = u;
		}
		
		
		public V getE1() {
			return e1;
		}

		public U getE2() {
			return e2;
			
		}
		
	}

