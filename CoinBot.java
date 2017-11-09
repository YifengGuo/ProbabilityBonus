package advanced_class7_DP4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CoinBot {
	
	static BigInteger binomial(final int N, final int K) {
		BigInteger ret = BigInteger.ONE;
		for (int k = 0; k < K; k++) {
			ret = ret.multiply(BigInteger.valueOf(N - k)).divide(BigInteger.valueOf(k + 1));
		}
		return ret;
	}
	
	static int getThreshold_GuessB(int flip) {
		double factor1 = 4.0 / 7.0;
		double factor2 = 2;
		for (int i = 0; i < flip; i++) {
			if (Math.pow(factor1, i) * Math.pow(factor2, flip - i) < 1.0) {
				return i;
			}
		}
		return -1;
	}
	
	static String flipCoinA(int flip_times) {
		double head = 0.4;
		double tail = 0.6;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < flip_times; i++) {
			double flip = Math.random();
			if(flip <= head) {
				sb.append("H ");
			} else {
				sb.append("T ");
			}
		}
		return sb.toString();
	}
	
	static String flipCoinB(int flip_times) {
		double head = 0.7;
		double tail = 0.3;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < flip_times; i++) {
			double flip = Math.random();
			if(flip <= head) {
				sb.append("H ");
			} else {
				sb.append("T ");
			}
		}
		return sb.toString();
	}
	public static void ngrams(Map<String,Integer> map,int n, String str) {
		String[] words = str.split(" ");
		for(int i = 0; i < words.length - n + 1; i++) {
			if(!map.containsKey(concat(words, i, i + n))) {
				map.put(concat(words, i, i + n), 0);
			}
			map.put(concat(words, i, i + n), map.get(concat(words, i, i + n)) + 1);
		}
		return;
	}

	public static String concat(String[] words, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < end; i++)
			sb.append((i > start ? " " : "") + words[i]);
		return sb.toString();
	}
	
	static int getLength(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'T' || s.charAt(i) == 'H') {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String line = "";
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		List<String> input1 = new ArrayList<>();
		List<String> input2 = new ArrayList<>();
		
		try {
			BufferedWriter bw1 = new BufferedWriter(new FileWriter("/Users/guoyifeng/Downloads/ProbabilityBonus/coinASequences.txt"));
			for (int i = 0; i < 50; i++) {
				String a = flipCoinA(100);
				bw1.write(a + "\n");
			}
			bw1.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		try {
			BufferedWriter bw2 = new BufferedWriter(new FileWriter("/Users/guoyifeng/Downloads/ProbabilityBonus/coinBSequences.txt"));
			for (int i = 0; i < 50; i++) {
				String b = flipCoinB(100);
				bw2.write(b + "\n");
			}
			bw2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
//		String a = flipCoinA(50);
//		String b = flipCoinB(50);
//		System.out.println(a);
//		System.out.println(b);

		try {
			br1 = new BufferedReader(new FileReader(
					"/Users/guoyifeng/Downloads/ProbabilityBonus/coinASequences.txt"));
			while ((line = br1.readLine()) != null) {
				input1.add(line);
			}
			br1.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			br2 = new BufferedReader(new FileReader(
					"/Users/guoyifeng/Downloads/ProbabilityBonus/coinBSequences.txt"));
			while ((line = br2.readLine()) != null) {
				input2.add(line);
			}
			br2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String, Integer> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();
		for(int j = 0; j < input1.size(); j++) {
			for(int i = 0; i <= 1000; i++) {
				ngrams(map1,i,input1.get(j));
			}
		}
		for(int j = 0; j < input2.size(); j++) {
			for(int i = 0; i <= 1000; i++) {
				ngrams(map2,i,input2.get(j));
			}
		}
		Iterator it1 = map1.entrySet().iterator();
		Iterator it2 = map2.entrySet().iterator();
		System.out.println("Coin A sequential pattern: ");
		while (it1.hasNext()) {
	        Map.Entry<String, Integer> pair = (Map.Entry)it1.next();
	        if(getLength(pair.getKey()) > 5 && pair.getValue() >= 0.9 * input1.size()) {
	        	System.out.println(pair.getKey() + " = " + pair.getValue());
	        }
	        it1.remove(); // avoids a ConcurrentModificationException
	    }
		System.out.println("\n\n\n");
		System.out.println("Coin B sequential pattern: ");
		while (it2.hasNext()) {
	        Map.Entry<String, Integer> pair = (Map.Entry)it2.next();
	        if(getLength(pair.getKey()) > 5 && pair.getValue() >= 0.9 * input2.size()) {
	        	System.out.println(pair.getKey() + " = " + pair.getValue());
	        }
	        it2.remove(); // avoids a ConcurrentModificationException
	    }
	}

}
