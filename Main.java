import java.io.IOException;

class State {
  byte[] mem = new byte[30*1000];
  int ptr = 0;

  public void Succ  () { mem[ptr]++; }
  public void Pred  () { mem[ptr]--; }

  public void Right () { ptr = ptr+1 % mem.length; }
  public void Left  () { ptr = ptr==0 ? mem.length : ptr-1;  }

  public void Output () { System.out.print((char) mem[ptr]); }
  public void Input  () {
    try {
      mem[ptr] = (byte) System.in.read();
    } catch (IOException e) {}
  }

  public byte getCell () { return mem[ptr]; }
}

class Interpreter {
  State s = new State();

  public void Interpret (String str) {
    for (int i = 0; i < str.length(); i++) {
      switch (str.charAt(i)) {
        case '+': s.Succ   (); break;
        case '-': s.Pred   (); break;
        case '<': s.Left   (); break;
        case '>': s.Right  (); break;
        case '.': s.Output (); break;
        case ',': s.Input  (); break;
        case '[':
          if (s.getCell() != 0) break;

          int l_balance = 1;
          while (l_balance > 0) {
            i++;
            if (str.charAt(i) == '[') l_balance++;
            if (str.charAt(i) == ']') l_balance--;
          }

          break;
        case ']':
          if (s.getCell() == 0) break;

          int r_balance = 1;
          while (r_balance > 0) {
            i--;
            if (str.charAt(i) == '[') r_balance--;
            if (str.charAt(i) == ']') r_balance++;
          }

          break;
      }
    }
  }
}

class Main {
  public static void main (String[] args) {
    Interpreter i = new Interpreter();
    i.Interpret("+++++ + [> +++++ +++++ + <-] > -.+..-.");
  }
}

