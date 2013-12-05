
package server.completion;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the server.completion package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Commit_QNAME = new QName("http://completion.Server/", "commit");
    private final static QName _RollBack_QNAME = new QName("http://completion.Server/", "rollBack");
    private final static QName _CommitResponse_QNAME = new QName("http://completion.Server/", "commitResponse");
    private final static QName _RollBackResponse_QNAME = new QName("http://completion.Server/", "rollBackResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: server.completion
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Commit }
     * 
     */
    public Commit createCommit() {
        return new Commit();
    }

    /**
     * Create an instance of {@link CommitResponse }
     * 
     */
    public CommitResponse createCommitResponse() {
        return new CommitResponse();
    }

    /**
     * Create an instance of {@link RollBackResponse }
     * 
     */
    public RollBackResponse createRollBackResponse() {
        return new RollBackResponse();
    }

    /**
     * Create an instance of {@link RollBack }
     * 
     */
    public RollBack createRollBack() {
        return new RollBack();
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link Commit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://completion.Server/", name = "commit")
    public JAXBElement<Commit> createCommit(Commit value) {
        return new JAXBElement<Commit>(_Commit_QNAME, Commit.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link RollBack }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://completion.Server/", name = "rollBack")
    public JAXBElement<RollBack> createRollBack(RollBack value) {
        return new JAXBElement<RollBack>(_RollBack_QNAME, RollBack.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link CommitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://completion.Server/", name = "commitResponse")
    public JAXBElement<CommitResponse> createCommitResponse(CommitResponse value) {
        return new JAXBElement<CommitResponse>(_CommitResponse_QNAME, CommitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link RollBackResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://completion.Server/", name = "rollBackResponse")
    public JAXBElement<RollBackResponse> createRollBackResponse(RollBackResponse value) {
        return new JAXBElement<RollBackResponse>(_RollBackResponse_QNAME, RollBackResponse.class, null, value);
    }

}
