package pt.tecnico.phonebook.domain;

import pt.ist.fenixframework.backend.jvstmojb.pstm.RelationList;
import pt.ist.fenixframework.backend.jvstmojb.ojb.OJBFunctionalSetWrapper;
import pt.ist.fenixframework.ValueTypeSerializer;


@SuppressWarnings("all")
public abstract class Person_Base extends pt.ist.fenixframework.backend.jvstmojb.pstm.OneBoxDomainObject {
    // Static Slots
    public final static pt.ist.fenixframework.dml.runtime.RoleOne<pt.tecnico.phonebook.domain.Person,pt.tecnico.phonebook.domain.PhoneBook> role$$phoneBook = new pt.ist.fenixframework.dml.runtime.RoleOne<pt.tecnico.phonebook.domain.Person,pt.tecnico.phonebook.domain.PhoneBook>() {
        @Override
        public pt.tecnico.phonebook.domain.PhoneBook getValue(pt.tecnico.phonebook.domain.Person o1) {
            return ((Person_Base.DO_State)o1.get$obj$state(false)).phoneBook;
        }
        @Override
        public void setValue(pt.tecnico.phonebook.domain.Person o1, pt.tecnico.phonebook.domain.PhoneBook o2) {
            ((Person_Base.DO_State)o1.get$obj$state(true)).phoneBook = o2;
        }
        public pt.ist.fenixframework.dml.runtime.Role<pt.tecnico.phonebook.domain.PhoneBook,pt.tecnico.phonebook.domain.Person> getInverseRole() {
            return pt.tecnico.phonebook.domain.PhoneBook.role$$person;
        }
        
    };
    public final static pt.ist.fenixframework.dml.runtime.RoleMany<pt.tecnico.phonebook.domain.Person,pt.tecnico.phonebook.domain.Contact> role$$contact = new pt.ist.fenixframework.dml.runtime.RoleMany<pt.tecnico.phonebook.domain.Person,pt.tecnico.phonebook.domain.Contact>() {
        public pt.ist.fenixframework.dml.runtime.RelationBaseSet<pt.tecnico.phonebook.domain.Contact> getSet(pt.tecnico.phonebook.domain.Person o1) {
            return ((Person_Base)o1).get$rl$contact();
        }
        public pt.ist.fenixframework.dml.runtime.Role<pt.tecnico.phonebook.domain.Contact,pt.tecnico.phonebook.domain.Person> getInverseRole() {
            return pt.tecnico.phonebook.domain.Contact.role$$person;
        }
        
    };
    
    public static pt.ist.fenixframework.dml.runtime.DirectRelation<pt.tecnico.phonebook.domain.PhoneBook,pt.tecnico.phonebook.domain.Person> getRelationPhoneBookContainsPersons() {
        return pt.tecnico.phonebook.domain.PhoneBook.getRelationPhoneBookContainsPersons();
    }
    
    private final static class PersonContainsContacts {
        private static final pt.ist.fenixframework.backend.jvstmojb.pstm.LoggingRelation<pt.tecnico.phonebook.domain.Person,pt.tecnico.phonebook.domain.Contact> relation = new pt.ist.fenixframework.backend.jvstmojb.pstm.LoggingRelation<pt.tecnico.phonebook.domain.Person,pt.tecnico.phonebook.domain.Contact>(role$$contact, "PersonContainsContacts");
    }
    public static pt.ist.fenixframework.dml.runtime.DirectRelation<pt.tecnico.phonebook.domain.Person,pt.tecnico.phonebook.domain.Contact> getRelationPersonContainsContacts() {
        return PersonContainsContacts.relation;
    }
    
    static {
        PersonContainsContacts.relation.setRelationName("pt.tecnico.phonebook.domain.Person.PersonContainsContacts");
    }
    private static pt.ist.fenixframework.dml.runtime.KeyFunction<Comparable<?>,pt.tecnico.phonebook.domain.Contact> keyFunction$$contact = new pt.ist.fenixframework.dml.runtime.KeyFunction<Comparable<?>,pt.tecnico.phonebook.domain.Contact>() { public Comparable<?> getKey(pt.tecnico.phonebook.domain.Contact value) { return value.getOid(); } public boolean allowMultipleKeys() {return false; }};
    
    // Slots
    
    // Role Slots
    private RelationList<pt.tecnico.phonebook.domain.Person,pt.tecnico.phonebook.domain.Contact> get$rl$contact() {
        return get$$relationList("contact", getRelationPersonContainsContacts());
        
    }
    
    // Init Instance
    
    private void initInstance() {
        init$Instance(true);
    }
    
    @Override
    protected void init$Instance(boolean allocateOnly) {
        super.init$Instance(allocateOnly);
        
    }
    
    // Constructors
    protected  Person_Base() {
        super();
    }
    
    // Getters and Setters
    
    public java.lang.String getName() {
        return ((DO_State)this.get$obj$state(false)).name;
    }
    
    public void setName(java.lang.String name) {
        ((DO_State)this.get$obj$state(true)).name = name;
    }
    
    private java.lang.String get$name() {
        java.lang.String value = ((DO_State)this.get$obj$state(false)).name;
        return (value == null) ? null : pt.ist.fenixframework.backend.jvstmojb.repository.ToSqlConverter.getValueForString(value);
    }
    
    private final void set$name(java.lang.String value, pt.ist.fenixframework.backend.jvstmojb.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).name = (java.lang.String)((value == null) ? null : value);
    }
    
    // Role Methods
    
    public pt.tecnico.phonebook.domain.PhoneBook getPhoneBook() {
        return ((DO_State)this.get$obj$state(false)).phoneBook;
    }
    
    public void setPhoneBook(pt.tecnico.phonebook.domain.PhoneBook phoneBook) {
        getRelationPhoneBookContainsPersons().add(phoneBook, (pt.tecnico.phonebook.domain.Person)this);
    }
    
    private java.lang.Long get$oidPhoneBook() {
        pt.ist.fenixframework.backend.jvstmojb.pstm.AbstractDomainObject value = (pt.ist.fenixframework.backend.jvstmojb.pstm.AbstractDomainObject) ((DO_State)this.get$obj$state(false)).phoneBook;
        return (value == null) ? null : value.getOid();
    }
    
    public void addContact(pt.tecnico.phonebook.domain.Contact contact) {
        getRelationPersonContainsContacts().add((pt.tecnico.phonebook.domain.Person)this, contact);
    }
    
    public void removeContact(pt.tecnico.phonebook.domain.Contact contact) {
        getRelationPersonContainsContacts().remove((pt.tecnico.phonebook.domain.Person)this, contact);
    }
    
    public java.util.Set<pt.tecnico.phonebook.domain.Contact> getContactSet() {
        return get$rl$contact();
    }
    
    public void set$contact(OJBFunctionalSetWrapper contact) {
        get$rl$contact().setFromOJB(this, "contact", contact);
    }
    
    @Deprecated
    public java.util.Set<pt.tecnico.phonebook.domain.Contact> getContact() {
        return getContactSet();
    }
    
    @Deprecated
    public int getContactCount() {
        return getContactSet().size();
    }
    
    
    protected void checkDisconnected() {
        DO_State castedState = (DO_State)this.get$obj$state(false);
        if (castedState.phoneBook != null) handleAttemptToDeleteConnectedObject("PhoneBook");
        if (get$rl$contact().size() > 0) handleAttemptToDeleteConnectedObject("Contact");
        
    }
    
    protected void readStateFromResultSet(java.sql.ResultSet rs, pt.ist.fenixframework.backend.jvstmojb.pstm.OneBoxDomainObject.DO_State  state) throws java.sql.SQLException {
        DO_State castedState = (DO_State)state;
        set$name(pt.ist.fenixframework.backend.jvstmojb.repository.ResultSetReader.readString(rs, "NAME"), state);
        castedState.phoneBook = pt.ist.fenixframework.backend.jvstmojb.repository.ResultSetReader.readDomainObject(rs, "OID_PHONE_BOOK");
    }
    protected pt.ist.fenixframework.dml.runtime.Relation get$$relationFor(String attrName) {
        if (attrName.equals("contact")) return getRelationPersonContainsContacts();
        return super.get$$relationFor(attrName);
        
    }
    protected pt.ist.fenixframework.backend.jvstmojb.pstm.OneBoxDomainObject.DO_State  make$newState() {
        return new DO_State();
        
    }
    protected void create$allLists() {
        super.create$allLists();
        get$$relationList("contact", getRelationPersonContainsContacts());
        
    }
    protected static class DO_State extends pt.ist.fenixframework.backend.jvstmojb.pstm.OneBoxDomainObject.DO_State {
        private java.lang.String name;
        private pt.tecnico.phonebook.domain.PhoneBook phoneBook;
        protected void copyTo(pt.ist.fenixframework.backend.jvstmojb.pstm.OneBoxDomainObject.DO_State  newState) {
            super.copyTo(newState);
            DO_State newCasted = (DO_State)newState;
            newCasted.name = this.name;
            newCasted.phoneBook = this.phoneBook;
            
        }
        
    }
    
}
