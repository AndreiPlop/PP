//import libraria principala polyglot din graalvm
import org.graalvm.polyglot.*;

import java.util.ArrayList;
import java.util.HashMap;


class Polyglot {

    private static String RToUpper(String token){
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        Value result = polyglot.eval("R", "toupper(\""+token+"\");");
        String resultString = result.asString();
        polyglot.close();

        return resultString;
    }

    private static int SumCRC(String token){
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        Value result = polyglot.eval("python", "sum(map(lambda x: 28 * x**5 + 4 * x**2 + 4, [ord(ch) for ch in '" + token.substring(1, token.length() - 1) + "']))");
        int resultInt = result.asInt();
        polyglot.close();

        return resultInt;
    }

    //functia MAIN
    public static void main(String[] args) {
        Context polyglot = Context.create();
        Value array = polyglot.eval("js", "[\"If\",\"we\",\"run\",\"the\",\"java\",\"command\",\"included\",\"in\",\"GraalVM\",\"we\",\"will\",\"be\",\"automatically\",\"using\",\"the\",\"Graal\",\"JIT\",\"compiler\",\"no\",\"extra\",\"configuration\",\"is\",\"needed\",\"I\",\"will\",\"use\",\"the\",\"time\",\"command\",\"to\",\"get\",\"the\",\"real\",\"wall\",\"clock\",\"elapsed\",\"time\",\"it\",\"takes\",\"to\",\"run\",\"the\",\"entire\",\"program\",\"from\",\"start\",\"to\",\"finish\",\"rather\",\"than\",\"setting\",\"up\",\"a\",\"complicated\",\"micro\",\"benchmark\",\"and\",\"I\",\"will\",\"use\",\"a\",\"large\",\"input\",\"so\",\"that\",\"we\",\"arent\",\"quibbling\",\"about\",\"a\",\"few\",\"seconds\",\"here\",\"or\",\"there\",\"The\",\"large.txt\",\"file\",\"is\",\"150\",\"MB\"];");
        HashMap<Integer, ArrayList<String>> hashMap = new HashMap<Integer, ArrayList<String>>();
        for (int i = 0; i < array.getArraySize();i++){
            String element = array.getArrayElement(i).asString();
            String upper = RToUpper(element);
            int crc = SumCRC(upper);

            if(hashMap.containsKey(crc)) {
                hashMap.get(crc).add(element);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(element);
                hashMap.put(crc, list);
            }
        }
        for (Integer val : hashMap.keySet()) {
            System.out.printf("CRC: %d\n", val);
            for(String elem : hashMap.get(val)) {
                System.out.printf("\t> %s", elem);
            }
        }
        polyglot.close();
    }
}