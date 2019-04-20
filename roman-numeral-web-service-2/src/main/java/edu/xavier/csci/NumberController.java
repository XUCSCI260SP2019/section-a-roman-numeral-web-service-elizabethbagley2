package edu.xavier.csci;

import org.springframework.web.bind.annotation.*;
import edu.xavier.csci.elizabethbagley2.RomanNumeralConverter;

@RestController
public class NumberController {

    /*
    Body json- { "numbers" : [ 1, 2, 3 ] }
    Response json - {"romanNumerals": [ "I", "II", "III" ] }
    */
    @PostMapping("/encode")
    public ResponseMultipleEncode multipleEncode(@RequestBody int roman) {
        ResponseMultipleEncode response = new ResponseMultipleEncode();

        response.setNumeral(RomanNumeralConverter.multipleEncode(roman));

        return response;

    }

    /*
    Response json - { "romanNumeral": "X" }
    */
    @GetMapping("/encode/{number}")
    public ResponseSingleEncode singleEncode(@PathVariable("number") int roman) {
        ResponseSingleEncode response = new ResponseSingleEncode();

        response.setNumeral(RomanNumeralConverter.singleEncode(roman));

        return response;
    }

    @PostMapping("/decode")
    public ResponseMultipleDecode multipleDecode(@RequestBody String num) {
        ResponseMultipleDecode response = new ResponseMultipleDecode();

        response.setNumber(romanNumeralConverter.multipleDecode(num));

        return response;
    }

    @GetMapping("/decode/{id}")

    public ResponseSingleDecode singleDecode(@PathVariable("id") String num) {
        ResponseSingleDecode response = new ResponseSingleDecode();

        response.setNumber(romanNumeralConverter.singleDecode(num));

        return response;
    }
}

