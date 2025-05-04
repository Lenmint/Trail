package org.lenmint.trail.jtx;

import java.util.ArrayList;

public abstract class JTXBinding {

    public enum Binding {
        Resources;

        public static ArrayList<String> getListString() {
            ArrayList<String> list = new ArrayList<>();
            // Add bindings here
            list.add("Resources");
            return list;
        }

        public static Binding contains (String bind) {
            if (Binding.getListString().contains(bind)){
                return Binding.valueOf(bind);
            }

            return null;
        }
    }

    public static boolean isBinding(String input, Binding binding) {
        if (input.startsWith("{@") && input.contains("(") && input.endsWith(")}")) {
            String bindString = input.substring(2);
            bindString = bindString.substring(0, bindString.indexOf('('));

            Binding bind = Binding.contains(bindString);
            return bind != null && bind == binding;
        }
        return false;
    }

    public static String getResourcesBindValue(String input) throws RuntimeException {
        // Check if binding is a `Resources` binding.
        if (isBinding(input, Binding.Resources)) {
            return input.substring(input.indexOf('(') + 1, input.indexOf(')'));
        }
        throw new RuntimeException("JTXBinding Error::Cannot get value from this binding: [" + input + "]");
    }
}
