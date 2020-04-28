public class StackAlgorithmus {

    private Stack<String> _stack = new Stack();
    public StackAlgorithmus () {
    }

    /**
     *
     * @param ausdruck
     * @return
     */
    protected int algebraischeBerechnung(String ausdruck) {
        String berechnung = "";
        int result = 0;
        for (int i = 0; i <= ausdruck.length() - 1; i++) {
            String element = ausdruck.charAt(i) + "";
   //         if (i < ausdruck.length() && ausdruck.charAt(i+1) > '0' && ausdruck.charAt(i+1) < '9' && ausdruck.charAt(i) > '0' && ausdruck.charAt(i) < '9') {
     //           String element2 = ausdruck.charAt(i+1) + "";
       //         element = element + element2;
         //   }
            if (element.equals (")")) {
                int operand1 = Integer.valueOf(_stack.pop());
                Character operator = _stack.pop().charAt(0);
                int operand2 = Integer.valueOf(_stack.pop());
                String dummy = _stack.pop();
                switch (operator) {
                    case '+': result = operand1 + operand2;
                    break;
                    case '-': result = operand2 - operand1;
                        break;
                    case '*': result = operand1 * operand2;
                        break;
                    case '/': result = operand2 / operand1;
                        break;
                }
                _stack.push(String.valueOf(result));
            } else {
                _stack.push(element);
            }
        }


        return result;
    }


}
