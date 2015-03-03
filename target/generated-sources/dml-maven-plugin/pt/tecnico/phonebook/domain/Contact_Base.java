package pt.tecnico.phonebook.domain;

import pt.ist.fenixframework.backend.jvstmojb.pstm.RelationList;
import pt.ist.fenixframework.backend.jvstmojb.ojb.OJBFunctionalSetWrapper;
import pt.ist.fenixframework.ValueTypeSerializer;


@SuppressWarnings("all")
public abstract class Contact_Base extends pt.ist.fenixframework.backend.jvstmojb.pstm.OneBoxDomainObject {
    // Static Slots
    public final static pt.ist.fenixframework.dml.runtime.RoleOne<pt.tecnico.phonebook.domain.Contact,pt.tecnico.phonebook.domain.Person> role$$person = new pt.ist.fenixframework.dml.runtime.RoleOne<pt.tecnico.phonebook.domain.Contact,pt.tecnico.phonebook.domain.Person>() {
        @Override
        public pt.tecnico.phonebook.domain.Person getValue(pt.tecnico.phonebook.domain.Contact o1) {
            return ((Contact_Base.DO_State)o1.get$obj$state(false)).person;
        }
        @Override
        public void setValue(pt.tecnico.phonebook.domain.Contact o1, pt.tecnico.phonebook.domain.Person o2) {
            ((Contact_Base.DO_State)o1.get$obj$state(true)).person = o2;
        }
        public pt.ist.fenixframework.dml.runtime.Role<pt.tecnico.phonebook.domain.Person,pt.tecnico.phonebook.domain.Contact> getInverseRole() {
            return pt.tecnico.phonebook.domain.Person.role$$contact;
        }
        
    };
    
    public static pt.ist.fenixframework.dml.runtime.DirectRelation<pt.tecnico.phonebook.domain.Person,pt.tecnico.phonebook.domain.Contact> getRelationPersonContainsContacts() {
        return pt.tecnico.phonebook.domain.Person.getRelationPersonContainsContacts();
    }
    
    // Slots
    
    // Role Slots
    
    // Init Instance
    
    private void initInstance() {
        init$Instance(true);
    }
    
    @Override
    protected void init$Instance(boolean allocateOnly) {
        super.init$Instance(allocateOnly);
        
    }
    
    // Constructors
    protected  Contact_Base() {
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
    
    public java.lang.Integer getPhoneNumber() {
        return ((DO_State)this.get$obj$state(false)).phoneNumber;
    }
    
    public void setPhoneNumber(java.lang.Integer phoneNumber) {
        ((DO_State)this.get$obj$state(true)).phoneNumber = phoneNumber;
    }
    
    private java.lang.Integer get$phoneNumber() {
        java.lang.Integer value = ((DO_State)this.get$obj$state(false)).phoneNumber;
        return (value == null) ? null : pt.ist.fenixframework.backend.jvstmojb.repository.ToSqlConverter.getValueForInteger(value);
    }
    
    private final void set$phoneNumber(java.lang.Integer value, pt.ist.fenixframework.backend.jvstmojb.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).phoneNumber = (java.lang.Integer)((value == null) ? null : value);
    }
    
    // Role Methods
    
    public pt.tecnico.phonebook.domain.Person getPerson() {
        return ((DO_State)this.get$obj$state(false)).person;
    }
    
    public void setPerson(pt.tecnico.phonebook.domain.Person person) {
        getRelationPersonContainsContacts().add(person, (pt.tecnico.phonebook.domain.Contact)this);
    }
    
    private java.lang.Long get$oidPerson() {
        pt.ist.fenixframework.backend.jvstmojb.pstm.AbstractDomainObject value = (pt.ist.fenixframework.backend.jvstmojb.pstm.AbstractDomainObject) ((DO_State)this.get$obj$state(false)).person;
        return (value == null) ? null : value.getOid();
    }
    
    
    protected void checkDisconnected() {
        DO_State castedState = (DO_State)this.get$obj$state(false);
        if (castedState.person != null) handleAttemptToDeleteConnectedObject("Person");
        
    }
    
    protected void readStateFromResultSet(java.sql.ResultSet rs, pt.ist.fenixframework.backend.jvstmojb.pstm.OneBoxDomainObject.DO_State  state) throws java.sql.SQLException {
        DO_State castedState = (DO_State)state;
        set$name(pt.ist.fenixframework.backend.jvstmojb.repository.ResultSetReader.readString(rs, "NAME"), state);
        set$phoneNumber(pt.ist.fenixframework.backend.jvstmojb.repository.ResultSetReader.readInteger(rs, "PHONE_NUMBER"), state);
        castedState.person = pt.ist.fenixframework.backend.jvstmojb.repository.ResultSetReader.readDomainObject(rs, "OID_PERSON");
    }
    protected pt.ist.fenixframework.dml.runtime.Relation get$$relationFor(String attrName) {
        return super.get$$relationFor(attrName);
        
    }
    protected pt.ist.fenixframework.backend.jvstmojb.pstm.OneBoxDomainObject.DO_State  make$newState() {
        return new DO_State();
        
    }
    protected void create$allLists() {
        super.create$allLists();
        
    }
    protected static class DO_State extends pt.ist.fenixframework.backend.jvstmojb.pstm.OneBoxDomainObject.DO_State {
        private java.lang.String name;
        private java.lang.Integer phoneNumber;
        private pt.tecnico.phonebook.domain.Person person;
        protected void copyTo(pt.ist.fenixframework.backend.jvstmojb.pstm.OneBoxDomainObject.DO_State  newState) {
            super.copyTo(newState);
            DO_State newCasted = (DO_State)newState;
            newCasted.name = this.name;
            newCasted.phoneNumber = this.phoneNumber;
            newCasted.person = this.person;
            
        }
        
    }
    
}
