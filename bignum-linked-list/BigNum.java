public class BigNum {
    private Link head;
    private Link tail;

    // Constructor to create a BigNum from a string of digits
    // Input: A string of digits representing a large non-negative integer (e.g., "123456789").
    // This method should convert the string into a doubly linked list where each node stores a single digit.
    // The most significant digit will be stored at the head, and the least significant digit will be at the tail.
    public BigNum(String numberStr) {
        for (int i = 0; i < numberStr.length(); i++) { // לולאה שעוברת על כל התווים (ספרות) במחרוזת
            char c = numberStr.charAt(i); // לוקחים את התו הנוכחי
            int digit = Character.getNumericValue(c); // ממירים את התו לספרה מספרית
            Link newNode = new Link(digit); // יוצרים צומת חדש שמכיל את הספרה(Node)
            if (head == null) { // אם זאת הספרה הראשונה – הרשימה עדיין ריקה
                head = newNode;
                tail = newNode;
            } else { // אחרת – יש כבר רשימה ואנחנו מוסיפים לסוף
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
    }

    // Default constructor that creates an empty BigNum with no digits.
    public BigNum() { }

    // Subtracts two BigNum objects and returns the result as a new BigNum
    // Input: Another BigNum object representing a large non-negative integer.
    // It can be assumed that this BigNum is greater than or equal to the other.
    // The subtraction should be done digit by digit, borrowing when needed.
    // Output: A new BigNum object representing the difference between the two numbers.
    public BigNum subtract(BigNum other) {
        // מצביעים לסוף של שני המספרים
        Link p1 = this.tail;
        Link p2 = other.tail;
        // תוצאה
        BigNum result = new BigNum();
        int borrow = 0;
        // ממשיכים כל עוד יש ספרות
        while (p1 != null || p2 != null) {
            int digit1 = 0;
            int digit2 = 0;
            // ספרה מהמספר הראשון
            if (p1 != null) {
                digit1 = p1.digit;
                p1 = p1.prev;
            }
            // ספרה מהמספר השני
            if (p2 != null) {
                digit2 = p2.digit;
                p2 = p2.prev;
            }
            // מפחיתים borrow קודם
            digit1 -= borrow;
            // אם צריך לעשות הלוואה
            if (digit1 < digit2) {
                digit1 += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            int diff = digit1 - digit2;
            // מוסיפים את הצומת לזנב result
            Link newNode = new Link(diff);
            if (result.head == null) {
                result.head = newNode;
                result.tail = newNode;
            } else {
                result.tail.next = newNode;
                newNode.prev = result.tail;
                result.tail = newNode;
            }
        }
        // הפיכת הרשימה
        reverse(result);
        // הסרת אפסים מיותרים
        removeLeadingZeros(result);
        return result;
    }
    private void removeLeadingZeros(BigNum num) {
        while (num.head != null && num.head.digit == 0 && num.head != num.tail) {
            num.head = num.head.next;
            num.head.prev = null;
        }
    }



    // Adds two BigNum objects and returns the result as a new BigNum
    // Input: Another BigNum object representing a large non-negative integer.
    // This method should add the current BigNum object with the input BigNum digit by digit.
    // It must handle carry-over when the sum of two digits exceeds 9.
    // Output: A new BigNum object representing the sum of the two numbers.
    public BigNum add(BigNum other) {
        // מצביעים לסוף של שני המספרים
        Link p1 = this.tail;
        Link p2 = other.tail;
        // תוצאה שנבנה
        BigNum result = new BigNum();
        int carry = 0; // שמירת סחיבה
        // נמשיך כל עוד יש ספרות או שיש carry
        while (p1 != null || p2 != null || carry != 0) {
            int digit1 = 0;
            int digit2 = 0;
            // לוקחים ספרה מ־this
            if (p1 != null) {
                digit1 = p1.digit;
                p1 = p1.prev;
            }
            // לוקחים ספרה מ־other
            if (p2 != null) {
                digit2 = p2.digit;
                p2 = p2.prev;
            }
            // חישוב סכום ספרות + סחיבה
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            int newDigit = sum % 10;
            // יצירת צומת חדש עם הספרה
            Link newNode = new Link(newDigit);
            // מוסיפים לזנב של התוצאה
            if (result.head == null) {
                result.head = newNode;
                result.tail = newNode;
            } else {
                result.tail.next = newNode;
                newNode.prev = result.tail;
                result.tail = newNode;
            }
        }
        reverse(result);
        return result;
    }
    // הופכת את הרשימה של מספר כך שה־head וה־tail יתחלפו
    private void reverse(BigNum num) {
        Link current = num.head;
        Link temp = null;
        // הופכים את כל הקישורים next <-> prev
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        // עדכון head ו־tail אחרי ההיפוך
        if (temp != null) {
            num.head = temp.prev;

            // עדכון tail החדש
            Link t = num.head;
            while (t.next != null) {
                t = t.next;
            }
            num.tail = t;
        }
    }


    // Multiplies two BigNum objects and returns the result as a new BigNum
    // Input: Another BigNum object representing a large non-negative integer.
    // This method multiplies the current BigNum object with the input BigNum, handling partial products and carries.
    // You need to shift the partial results as required, similar to how manual long multiplication is done.
    // Output: A new BigNum object representing the product of the two numbers.
    public BigNum multiply(BigNum other) {
        // אם אחד מהם 0 – התוצאה 0
        if (this.head == null || other.head == null) {
            return new BigNum("0");
        }
        BigNum result = new BigNum("0"); // מתחילים מ-0
        Link p2 = other.tail;   // מצביע על ספרות OTHER
        int shift = 0;          // כמה אפסים להוסיף בסוף כל תוצאה חלקית
        // נרוץ על ספרות other מהסוף להתחלה
        while (p2 != null) {
            BigNum partial = new BigNum();   // תוצאה חלקית
            int carry = 0;
            Link p1 = this.tail;   // מצביע על ספרות THIS
            // מוסיפים אפסים (shift) בתחילת התוצאה החלקית
            for (int i = 0; i < shift; i++) {
                Link zeroNode = new Link(0);

                if (partial.head == null) {
                    partial.head = zeroNode;
                    partial.tail = zeroNode;
                } else {
                    partial.tail.next = zeroNode;
                    zeroNode.prev = partial.tail;
                    partial.tail = zeroNode;
                }
            }
            // כפל ספרה-בספרה
            while (p1 != null) {
                int mul = p1.digit * p2.digit + carry;
                carry = mul / 10;
                int newDigit = mul % 10;
                Link newNode = new Link(newDigit);
                if (partial.head == null) {
                    partial.head = newNode;
                    partial.tail = newNode;
                } else {
                    partial.tail.next = newNode;
                    newNode.prev = partial.tail;
                    partial.tail = newNode;
                }
                p1 = p1.prev;
            }
            // אם נשאר carry
            if (carry > 0) {
                Link newNode = new Link(carry);
                partial.tail.next = newNode;
                newNode.prev = partial.tail;
                partial.tail = newNode;
            }
            // להפוך את התוצאה החלקית
            reverse(partial);
            // להוסיף לתוצאה הראשית
            result = result.add(partial);
            // עוברים לספרה הבאה ב-other
            p2 = p2.prev;
            shift++;
        }
        // הסרת אפסים מובילים
        removeLeadingZeros(result);
        return result;
    }

    // Converts the linked list back to a string representation of the number
    // Output: A string that represents the linked list as a number (e.g., "123456789").
    public String toString() {
        StringBuilder result = new StringBuilder();
        Link current = head;
        while (current != null) {
            result.append(current.digit);
            current = current.next;
        }
        return result.toString();
    }
}


