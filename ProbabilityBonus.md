



# Probability Bonus #



######Please open this markdown file with $typora$ with inline Math enabled if other markdown editor has trouble opening it######

## 1 Preliminaries ##



#####0) Argue that if a coin has a probability of heads p, then out of n independent flips, if X is the number of heads, then#####

​                       P(X = k) = ${k}\choose{n} $$p^k$$(1-p)^{n-k}$



Solution:

​	P(X = k) = $\sum_{y} $$P(X = k, Y = n - k)$

​                      = $\sum_{y}^{n - k}$$P(X = k | Y = (n - k))P(Y = n - k)$

​        Because if k is fixed, then (n - k) is fixed. And n is constant. So given k, there is only one potential value for n - k. And in (n - k) times out of n flips we meet tails. So the potential sequences are ${n - k}\choose{n}$

=> $P(X = k)$ = ${n - k}\choose{n}$$P(X = k)P(Y = n - k)$

​                        = ${n - k}\choose{n}$$p^k$$(1 - p)^{n - k}$ 

​                        = ${k}\choose{n}$$p^k(1-p)^{n - k}$



## 2 The Coin Bot ##

#####1） Prove that, for any n, $P_A(n) + P_B(n) = 1$.#####

given:

| Coin / Res | Head | Tail |
| ---------- | ---- | ---- |
| Coin = A   | 0.4  | 0.6  |
| Coin = B   | 0.7  | 0.3  |



$P_A(n) = P(coin = A | F_1,F_2…F_n)$

$P_B(n) = P(coin = B | F_1,F_2…F_n)$

$P_A(n) + P_B(n) = P(coin = A | F_1,F_2…F_n) + P(coin = B | F_1,F_2…F_n)$

​                             $=\frac{P(coin = A, F_1,F_2…F_n )}{P(F_1,F_2…F_n)} + \frac{P(coin = B, F_1,F_2…F_n )}{P(F_1,F_2…F_n)}$

Here we can know from problem that both coin A and coin B can generate conin sequence as F1, F2…Fn

So $P(F_1, F_2…F_n)$  and P(coin) are two independent events

=> $P_A(n) + P_B(n) = \frac{[P(coin = A) + P(coin = B)]P(F_1,F_2…F_n)}{P(F_1, F_2…F_n)}$

​                                  $= P(coin = A) + P(coin = B)$

And we are given only one unique coin so the coin must be A or B.

And  $ P(coin = A) + P(coin = B) = 1$

So $P_A(n) + P_B(n) = 1$



#####2) Prove that for any n, pA(n) and pB(n) depend only on the number of heads and tails recorded rather than the specific order of flips collected. Give an explicit formula for both in terms of the respective probabilities, and the total number of heads recorded in n flips, Headsn.#####

$P_A(n) = P(coin = A | F_1,F_2…F_n)$

$P_B(n) = P(coin = B | F_1,F_2…F_n)$

If coin is A:

​	$P_A(n) = P(coin = A | F_1, F_2…F_n)$

​                     $=\frac{P(coin = A, F_1,F_2…F_n )}{P(F_1,F_2…F_n)}$

For $P(F_1,F_2…F_n)$

Because each time the flip is independent event and previous result cannot affect next flip's result. So $P(F_1,F_2…F_n) = P(F_1)P(F_2)…P(F_n)$. Since they are all independent, so the order of sequence does not matter. And what will affect the value of product is each flip's result. 

And assume heads occurrence in sequence is $Heads_n$ out of n flips. From 0) we have 

$P(X = Heads_n) =$ ${Heads_n}\choose{n}$$p^{Heads_n}(1 - p)^{n - Heads_n}$

​	$ P_A(n) = $${Heads_n}\choose{n}$$(0.4)^{Heads_n}$$(0.6)^{n - Heads_n}$$P(coin = A)$

Similar:

​	$ P_B(n) = $${Heads_n}\choose{n}$$(0.7)^{Heads_n}$$(0.3)^{n - Heads_n}$$P(coin = B)$



#####3) Simplify the test pB(n) > pA(n) as much as possible to a simple test on the value of Headsn.#####

$Guess_n = A$ if  $ P_A(n) \geq P_B(n) $

$Guess_n = B$ if  $ P_B(n) > P_A(n) $

If $Guess_n = B$:

​	$ P_B(n) > P_A(n) $

​	$P(coin = B | F_1, F_2…F_n) > P(coin = A | F_1, F_2…F_n)$

​	${Heads_n}\choose{n}$$(0.4)^{Heads_n}$$(0.6)^{n - Heads_n}$$P(coin = A)$	> ${Heads_n}\choose{n}$$(0.7)^{Heads_n}$$(0.3)^{n - Heads_n}$$P(coin = B)$

​	$P(coin = B) > (\frac{4}{7})^{Heads_n} * 2^{n - Heads_n}P(coin = A)$

Because without any other prior distribution, $P(coin = B) = P(coin = A) = 0.5$

Then $ P_B(n) > P_A(n) \equiv (\frac{4}{7})^{Heads_n} * 2^{n - Heads_n} < 1$ 



#####4)  What is $P (Guessn = B|Coin = A)$? That is, if the coin were actually A, what is the probability that after $n$ flips, we would guess that the coin is B? What is $P (Guessn = A|Coin = B)$? Hint: What can / should you marginalize on? Give answers for $n$ = 5, 10, 100#####

$P(Guess_n = B | coin = A)$

$= \sum_{Heads_n}P(Guess_n = B, Heads_n | coin = A)$$P(Heads_n | coin = A)$

From 3) we know if $Guess_n = B$ then $(\frac{4}{7})^{Heads_n} * 2^{n - Heads_n} < 1 $ 

​	4.1

​	 if $n = 5$  => $Heads_n \geq 3$

​	$P(Guess_n = B | coin = A) = P(Heads_n = 3 | coin = A) + P(Heads_n = 4 | coin = A) + P(Heads_n = 5 | coin = A)$

​						$ = $${3}\choose{5}$$0.4^{3}0.6^{2}$ + ${4}\choose{5}$$0.4^{4}0.6^{1}$ + ${5}\choose{5}$$0.4^{5}0.6^{0}$

​						$ = 0.2304 + 0.0768 + 0.01024$			

​						$ = 0.31744$

Similar: 

$P(Guess_n = A| coin = B)  = $${0}\choose{5}$$0.3^{5}0.7^{0}$ + ${1}\choose{5}$$0.3^{4}0.7^{1}$ + ${2}\choose{5}$$0.3^{3}0.7^{2}$ $= 0.16308$

​	4.2

​	 if $n = 10$  => $Heads_n \geq 6$

​	$P(Guess_n = B | coin = A) = P(Heads_n = 6| coin = A) + P(Heads_n = 7 | coin = A) $

​       				$+ P(Heads_n = 8| coin = A) +  P(Heads_n = 9| coin = A) +  P(Heads_n = 10| coin = A)$

​	$=$ ${6}\choose{10}$$0.4^{6}0.6^{4}$ + ${7}\choose{10}$$0.4^{7}0.6^{3}$ + ${8}\choose{10}$$0.4^{8}0.6^{2}$ + ${9}\choose{10}$$0.4^{9}0.6^{1}$ + ${10}\choose{10}$$0.4^{10}0.6^{0}$

​	$ = 0.1662$

Similar:

​	$P(Guess_n = A | coin = B)  = 0.1501$	

​	4.3	

​	 if $n = 100$  => $Heads_n \geq $56

​	$P(Guess_n = B | coin = A)$ $=$ $P(Heads_n = 56 : 100 | coin = A)$

​							$= \sum_{Heads_n = 56}^{100}P(Heads_n | coin = A)$

​							$=\sum_{Heads_n=56}^{100}$${Heads_n}\choose{100}$$0.4^{Heads_n}$$0.6^{100 - Heads_n}$

​							$\approx0$

Similar: 

​	$P(Guess_n = A | coin = B) \approx0$

So when the experiment times of filpping becomes larger, it is very unlikely to have a wrong guess given observation sequneces.



#####5) Combining the results of the previous question, what is

​				$P (Guessn \neq Coin)$? 

#####What should you marginalize on? What are your priors? Give answers for n = 5, 10, 100.#####

Solution:

​	$P (Guessn \neq Coin)$

​	$=P(Guess_n = B | coin = A)P(coin=A)$ $+$ $P(Guess_n = A | coin = B)P(coin = B)$

​	from soluton of question 4):

​	if $n = 5$ :

​		$P (Guessn \neq Coin)$

​		$=0.31744 * 0.5 + 0.16308 * 0.5 \approx0.240$

​	if $n = 10$:

​		$P (Guessn \neq Coin)$

​		$=0.1662 * 0.5 + 0.1501 * 0.5 \approx0.158$

​	if $n=100$:

​		$P (Guessn \neq Coin)$

​		$\approx0$

#####6) What is the smallest n such that P (Guessn 6= Coin) ≤ 0.1? How does this inform how many times you ought to experiment by flipping? #####

​	To find smallest $n$ such that $P(Guess_n \neq coin)$ we just need to iterate $n$ from 0 and stop the loop when $P(Guess_n \neq coin) \le 0.1$

​	This question is solved by a Java program I wrote which applied BigDecimal and BigInteger to calculate very small probability and very large binomial number

```
import java.math.BigDecimal;
import java.math.BigInteger;

public class BinomialBigInteger {
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
	
	static BigDecimal getPGuessBCoinA(int flip) {
		BigDecimal P_gB_cA = null;
		BigDecimal res = BigDecimal.ZERO;
		int threshold = getThreshold_GuessB(flip);
		for (int i = threshold; i <= flip; i++) {
			BigInteger temp = binomial(flip, i);
			P_gB_cA = new BigDecimal(temp);
			P_gB_cA = P_gB_cA.multiply(new BigDecimal(Math.pow(0.4, i)));
			P_gB_cA = P_gB_cA.multiply(new BigDecimal(Math.pow(0.6, flip - i)));
			res = res.add(P_gB_cA);
		}
		return res;
	}
	
	static BigDecimal getPGuessACoinB(int flip) {
		BigDecimal P_gA_cB = null;
		BigDecimal res = BigDecimal.ZERO;
		int threshold = getThreshold_GuessB(flip);
		for (int i = 0; i <= threshold - 1; i++) {
			BigInteger temp = binomial(flip, i);
			P_gA_cB = new BigDecimal(temp);
			P_gA_cB = P_gA_cB.multiply(new BigDecimal(Math.pow(0.7, i)));
			P_gA_cB = P_gA_cB.multiply(new BigDecimal(Math.pow(0.3, flip - i)));
			res = res.add(P_gA_cB);
		}
		return res;
	}
	public static void main(String[] args) {
		int flip = 1000;
		int res = 0;
		System.out.println(getThreshold_GuessB(10));
		System.out.println(getPGuessBCoinA(10));
		System.out.println(getPGuessACoinB(10));
		for (int i = 0; i < flip; i++) { // find smallest flip which satisfies  P (Guessn != Coin) ≤ 0.1
			BigDecimal P_gB_cA = getPGuessBCoinA(i);
			BigDecimal P_gA_cB = getPGuessACoinB(i);
			// System.out.println(getThreshold_GuessB(i));
			// System.out.println("failed this time");
			if (P_gB_cA.add(P_gA_cB).doubleValue() * 0.5 <= 0.1) {
				res = i;
				System.out.println(i);
				return;
			}
		}
	}
}
```

And the program will return 17.

So the smallest $n$ which make $P(Guess_n \neq coin) \le 0.1$ is 17.

And this can inform us when experimenting, flip the coin for at least 17 times can minish the probability of having wrong guess.



#####7) The answer to the previous question can inform how many experiments you ought to do. But once you have performed those experiments, it is reasonable to ask - what is the probability that you guessed wrong? i.e., what is $P (Guessn \neq Coin|F1, F2, . . . , Fn)$ or $P (Guessn 6= Coin|Headsn)$? 

#####What should you marginalize on? Given the data, is Guessn random?#####

So assume the flip times = 17 for the experiment.

And the threshold when flip = 17 is 10 calculated by the program.

And given observation sequence, the guess is fixed because it only depends on the $Heads_n$

If $:n=17$:

​	 we have $Guess_n = B$ if $Heads_n \geq 10$

​			$Guess_n = A$ if $Heads_n <10$

```
static BigDecimal getPGuessBCoinA(int flip) {
		BigDecimal P_gB_cA = null;
		BigDecimal res = BigDecimal.ZERO;
		BigDecimal max = BigDecimal.ZERO;
		int headsnMax = 0;
		int threshold = getThreshold_GuessB(flip);
		for (int i = threshold; i <= flip; i++) {
			BigInteger temp = binomial(flip, i);
			P_gB_cA = new BigDecimal(temp);
			P_gB_cA = P_gB_cA.multiply(new BigDecimal(Math.pow(0.4, i))); // head
			P_gB_cA = P_gB_cA.multiply(new BigDecimal(Math.pow(0.6, flip - i))); // tail
			if (P_gB_cA.compareTo(max) > 0) {
				headsnMax = i;
				max = P_gB_cA;
			}
			System.out.println("headsn: " + i + " P_gB_cA: " + P_gB_cA +" max: "+ max +" max_headsn "+ headsnMax);
			res = res.add(P_gB_cA);
		}
		return res;
	}
	
	static BigDecimal getPGuessACoinB(int flip) {
		BigDecimal P_gA_cB = null;
		BigDecimal res = BigDecimal.ZERO;
		BigDecimal max = BigDecimal.ZERO;
		int headsnMax = 0;
		int threshold = getThreshold_GuessB(flip);
		for (int i = 0; i <= threshold - 1; i++) {
			BigInteger temp = binomial(flip, i);
			P_gA_cB = new BigDecimal(temp);
			P_gA_cB = P_gA_cB.multiply(new BigDecimal(Math.pow(0.7, i))); // head
			P_gA_cB = P_gA_cB.multiply(new BigDecimal(Math.pow(0.3, flip - i))); // tail
			if (P_gA_cB.compareTo(max) > 0) {
				headsnMax = i;
				max = P_gA_cB;
			}
			System.out.println("headsn: " + i + " P_gA_cB: " + P_gA_cB + " max: " + max + " max_headsn "+ headsnMax);
			res = res.add(P_gA_cB);
		}
		return res;
	}
```

$P(Guess_n\neq coin | Heads_n)$ could marginalize on the occurrence of $Heads_n$ by methods above

| $P(Guess_n\neq coin | Heads_n)$ | occurrence of $Heads_n$ |
| ------------------------------- | ----------------------- |
| 1.29E-9                         | 0                       |
| 5.12E-8                         | 1                       |
| 9.56E-7                         | 2                       |
| 0.000011                        | 3                       |
| 0.000091                        | 4                       |
| 0.000552                        | 5                       |
| 0.002579                        | 6                       |
| 0.009457                        | 7                       |
| 0.027584                        | 8                       |
| 0.064363                        | 9                       |
| 0.057086                        | 10                      |
| 0.024218                        | 11                      |
| 0.008072                        | 12                      |
| 0.002069                        | 13                      |
| 0.000394                        | 14                      |
| 0.000052                        | 15                      |
| 0.000004                        | 16                      |
| 1.72E-7                         | 17                      |



![alt text](https://raw.githubusercontent.com/YifengGuo/ProbabilityBonus/master/Q8.png)

So from the image we know that when $Heads_n = 9$ we have maximum $P (Guessn \neq Coin|Heads_n) $ 

And its probability is 0.064363



9) Freeform question: Suppose that you know that the coin is Coin A, but after some (unknown) number of flips, someone is going to swap it for Coin B without telling you. Design a test CoinBot can use to try to determine when / if the coin has been swapped. What can you say about the probability of CoinBot declaring the coin has been swapped before it was actually swapped (false positives)? What can you say about how many flips it takes for CoinBot to realize the coin has been swapped?

Actually I do not have an exact answer to this question. Here is the rough thought to this question: 

Since we do know we are flipping coin A at the very begining, what I think that may work is to model the sequence of flipping coin A and coin B. For instance, if we have flip 100 times (maybe more) and we do not konw at which moment the coin has been swapped. And at that time, we can use a bot to flip coin with coin A and coin B separately. After flipping each coin say about 100 times, then at this moment we have 50 sequences which is 100 long recording heads and tails for each coin.

And this problem is converted to a sequential pattern problem. We can analyze on these 100 sequences (or maybe more) . prefix_sum or ngram or any other sequential pattern fetch algorithms can be used here to fetch the sequential patterns. And we say the sequential pattern which occurs more than like 0.9 and length > 5 in total sequences are essencial (like HHHHH for coin B). And we can have several patterns for both coins. And with these patterns we can analyze coin sequence we initially flip, we can just directly iterate sequential patterns on the original sequence and check the distribution of sequential patterns for each coin, and then we can have a rough knowledge of which sub-sequence is conducted by flipping coin A and which another sub-sequence is conducted by coin B.

The code below is a program which can fetch sequential pattern for coin A and coin B

```
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
```

