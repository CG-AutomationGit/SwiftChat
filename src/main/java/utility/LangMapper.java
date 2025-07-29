package utility;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LangMapper {
    private static String currentLang = "Gujarati"; // default

    private static final Map<String, Map<String, String>> langMap = new HashMap<>();
    static Map<String, String> gujaratiMap = new HashMap<>();
    static {

        gujaratiMap.put("Next", "આગળ વધો");
        gujaratiMap.put("English", "ગુજરાતી");
        gujaratiMap.put("Submit", "સબમિટ કરો");
        gujaratiMap.put("Cancel", "રદ કરો");
        gujaratiMap.put("Login", "પ્રવેશ કરો");
        gujaratiMap.put("Logout", "લૉગ આઉટ કરો");
        gujaratiMap.put("Welcome", "સ્વાગત છે");
        gujaratiMap.put("Settings", "સેટિંગ્સ");
        gujaratiMap.put("Profile", "પ્રોફાઇલ");
        gujaratiMap.put("Search", "શોધો");
        gujaratiMap.put("Help", "મદદ");
        gujaratiMap.put("Error", "ભૂલ");
        gujaratiMap.put("Loading", "લોડ થઈ રહ્યું છે");
        gujaratiMap.put("Save", "સાચવો");
        gujaratiMap.put("Delete", "મિટાવો");
        gujaratiMap.put("Edit", "સંપાદિત કરો");
        gujaratiMap.put("View", "જુઓ");
        gujaratiMap.put("Confirm", "પુષ્ટિ કરો");
        gujaratiMap.put("Yes", "હા");
        gujaratiMap.put("No", "ના");
        gujaratiMap.put("Home", "ઘર");
        gujaratiMap.put("Notifications", "સૂચનાઓ");
        gujaratiMap.put("Messages", "સંદેશો");
        gujaratiMap.put("Profile Settings", "પ્રોફાઇલ સેટિંગ્સ");
        gujaratiMap.put("Change Language", "ભાષા બદલો");
        gujaratiMap.put("Feedback", "પ્રતિસાદ");
        gujaratiMap.put("About Us", "અમારા વિશે");
        gujaratiMap.put("Contact Us", "અમારો સંપર્ક કરો");
        gujaratiMap.put("Terms and Conditions", "નિયમો અને શરતો");
        gujaratiMap.put("Privacy Policy", "ગોપનીયતા નીતિ");
        gujaratiMap.put("FAQ", "વારંવાર પૂછાતા પ્રશ્નો");
        gujaratiMap.put("Support", "સહાય");
        gujaratiMap.put("Version", "આવૃત્તિ");
        gujaratiMap.put("Update Available", "અપડેટ ઉપલબ્ધ છે");
        gujaratiMap.put("No Data Found", "ડેટા મળ્યો નથી");
        gujaratiMap.put("Retry", "પુનઃ પ્રયાસ કરો");
        gujaratiMap.put("Loading More", "વધુ લોડ કરી રહ્યું છે");
        gujaratiMap.put("Connection Error", "કનેક્શન ભૂલ");
        gujaratiMap.put("Session Expired", "સત્ર સમાપ્ત થયું");
        gujaratiMap.put("Please Wait", "કૃપા કરીને રાહ જુઓ");
        gujaratiMap.put("Welcome Back", "પાછા આવો");
        gujaratiMap.put("Sign Up", "સાઇન અપ કરો");
        gujaratiMap.put("Forgot Password", "પાસવર્ડ ભૂલી ગયા છો");
        gujaratiMap.put("Reset Password", "પાસવર્ડ પુનઃસેટ કરો");
        gujaratiMap.put("Change Password", "પાસવર્ડ બદલો");
        gujaratiMap.put("Old Password", "જૂનો પાસવર્ડ");
        gujaratiMap.put("New Password", "નવો પાસવર્ડ");
        gujaratiMap.put("Confirm Password", "પાસવર્ડ પુષ્ટિ કરો");
        gujaratiMap.put("Password Mismatch", "પાસવર્ડ મેળ ખાતો નથી");
        gujaratiMap.put("Invalid Credentials", "અમાન્ય પ્રમાણપત્રો");
        gujaratiMap.put("Account Created", "ખાતું બનાવાયું");
        gujaratiMap.put("Account Updated", "ખાતું અપડેટ થયું");
        gujaratiMap.put("Account Deleted", "ખાતું મિટાવવામાં આવ્યું");
        gujaratiMap.put("Profile Updated", "પ્રોફાઇલ અપડેટ થઈ");
        gujaratiMap.put("Profile Picture Updated", "પ્રોફાઇલ છબી અપડેટ થઈ");
        gujaratiMap.put("Language Changed", "ભાષા બદલાઈ");



        langMap.put("Gujarati", gujaratiMap);
    }

    public static String getLocalized(String key, String lang) {
        if(lang.equals("English")) {
            return key; // Assuming English is the default language and keys are in English
        } else if (lang.equalsIgnoreCase("Gujarati")) {
          return gujaratiMap.get(key); // Return the Gujarati translation or the key if not found
        } else {
            return key; // Fallback to the key if language is not supported
        }
    }
}
