#HTML4J#
##Developed by Eyeballcode##
---------
Here's how to use it:

    HTML html = new HTML();
    BODY body = new BODY();
    html.addElement(body);

This makes the basic framework for everything.

    A link = new A();
    link.href = "http://github.com/Eyeballcode";
    body.addElement(link);

Up to this point, no real work is done. To get the source, do

    String source = html.getSource(0);

The `0` is to tell the API the initial indentation. We normally start with 0, but you can use whatever you want.

--------------------
Here's how to have your own element:
1. Define a class for the element
-------------

    public class MyHTMLElement extends HTMLElement
Now, declare all the methods using whatever you want. THe most important is:
    public String getElementTagName();

The value is what comes out in the HTML. So returning `hello` results in `<hello></hello>`
For `getSource(int spaces)`, I use `SourceHelper.getSource(spaces, this)` as it helps reduce and dry code.

2. Define your own attributes
-------------
Now we made a class. Cool! But...

    <hello myName="eyeball" location="Singapore" id="helloText" class="myCSSClass"></hello>

How do we do that? Good question! Put this in your element's class:

    @Attribute
    public String myAttribute = "";
    // The field's name is the attribute's name!

Simple! Now when generating the source, it does:

 * Get everything with `@Attribute` and store it in an array
 * Go through each field.
 * If it is empty or `null`, skip.
 * Otherwise append it the the tag and it's value.
Done!

Happy hacking away...
