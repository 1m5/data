package io.onemfive.data.content;

/**
 * TODO: Add Description
 *
 * @author objectorange
 */
public class JSON extends Text {

    public JSON() {
    }

    public JSON(byte[] body, String contentType) {
        super(body, contentType);
    }

    public JSON(byte[] body, String contentType, String name, boolean generateFullHash, boolean generateShortHash) {
        super(body, contentType, name, generateFullHash, generateShortHash);
    }
}
