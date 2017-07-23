/*
Design a data structure that has the ability to limit N hits in last seconds. hit() if exceeds limit return false return true
digest() if empty return false else return true and digest the first hit
*/

public class LoacLimit {
	public static class Token {
		//simulate Token
		int timeStamp;
		int val;
		public Token(int timeStamp, int val) {
			this.timeStamp = timeStamp;
			this.val = val;
		}
	}

	Token[] circularArray;
	int beg;
	int end;
	boolean isFull;
	int timeLimit;
	int hitLimit;

	public LoadLimit(int timeLimit, int hitLimit) P{
		//Define circular array
		this.circularArray = new Token(hitLimit);
		this.hitLimit = hitLimit;
		this.beg = 0;
		this.end = 0;
	}

	public boolean hit(Token token) {
		if (isFull) {
			//beg = end
			Token begToken = circularArray[beg];
			if (token.timeStamp - begToken.timeStamp >= timeLimit) {
				circularArray[end] = token;
				end = (end + 1) % hitLimit;
				beg = end;
				isFull = true;
				return true;
			} else {
				return false;
			}
		} else {
			if (beg == end) {
				//empty
				circularArray[beg] = token;
				end = (end + 1) % hitLimit;
				return true;
			} else {
				//Normal case
				circularArray[end] = token;
				end = (end + 1) % hitLimit;
				if (beg == end) {
					isFull = true;
				}
				return fasle;
			}
		}
	}

	public boolean digest() {
		if (isFull) {
			circularArray[beg] = null;
			beg = (beg + 1) % hitLimit;
			isFull = false;
			return true;
		} else {
			if (beg == end) {
				//empty array
				return false;
			} else {
				//normal case
				circularArray[beg] = null;
				beg = (beg + 1) % hitLimit;
				return true;
			}
		}
	}

	public static void main(String[] args) {
		LoadLimit loadLimit = new LoadLimit(4, 5);

		System.out.println("=====Test Case 1=====");
		System.out.println(loadLimit.hit(new Token(1, 1)));
		System.out.println(loadLimit.hit(new Token(2, 2)));
		System.out.println(loadLimit.hit(new Token(3, 3)));
		System.out.println(loadLimit.hit(new Token(3, 4)));
		System.out.println(loadLimit.hit(new Token(4, 5)));
		//hit limit return false
		System.out.println(loadLimit.hit(new Token(4, 6)));
		//overwrite pre token return true
		System.out.println(loadLimit.hit(new Token(10, 7)));

		System.out.println("===== Test Case 2=====");
		loadLimit = new LoadLimit(4, 5);
		System.out.println(loadLimit.hit(new Token(1, 1)));
		System.out.println(loadLimit.hit(new Token(2, 2)));
		System.out.println(loadLimit.hit(new Token(3, 3)));
		System.out.println(loadLimit.hit(new Token(3, 4)));
		System.out.println(loadLimit.digest());
		//un-hit limit return true
		System.out.println(loadLimit.hit(new Token(4, 6)));
		System.out.println(loadLimit.hit(new Token(4, 7)));
		//hit limit return fasle
		System.out.println(loadLimit.hit(new Token(4, 8)));
	}
}
































