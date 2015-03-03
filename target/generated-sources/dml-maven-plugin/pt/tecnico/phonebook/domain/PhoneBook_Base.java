package pt.tecnico.phonebook.domain;

import pt.ist.fenixframework.backend.jvstmojb.pstm.RelationList;
import pt.ist.fenixframework.backend.jvstmojb.ojb.OJBFunctionalSetWrapper;
import pt.ist.fenixframework.ValueTypeSerializer;


@SuppressWarnings("all")
public abstract class PhoneBook_Base extends pt.ist.fenixframework.backend.jvstmojb.pstm.OneBoxDomainObject {
    // Static Slots
    public final static pt.ist.fenixframework.dml.runtime.RoleMany<pt.tecnico.phonebook.domain.PhoneBook,pt.tecnico.phonebook.domain.Person> role$$person = new pt.ist.fenixframework.dml.runtime.RoleMany<pt.tecnico.phonebook.domain.PhoneBook,pt.tecnico.phonebook.domain.Person>() {
        public pt.ist.fenixframework.dml.runtime.RelationBaseSet<pt.tecnico.phonebook.domain.Person> getSet(pt.tecnico.phonebook.domain.PhoneBook o1) {
            return ((PhoneBook_Base)o1).get$rl$person();
        }
        public pt.ist.fenixframework.dml.runtime.Role<pt.tecnico.phonebook.domain.Person,pt.tecnico.phonebook.domain.PhoneBook> getInverseRole() {
            return pt.tecnico.phonebook.domain.Person.role$$phoneBook;
        }
        
    };
    public final static pt.ist.fenixframework.dml.runtime.RoleOne<pt.tecnico.phonebook.domain.PhoneBook,pt.ist.fenixframework.DomainRoot> role$$root = new pt.ist.fenixframework.dml.runtime.RoleOne<pt.tecnico.phonebook.domain.PhoneBook,pt.ist.fenixframework.DomainRoot>() {
        @Override
        public pt.ist.fenixframework.DomainRoot getValue(pt.tecnico.phonebook.domain.PhoneBook o1) {
            return ((PhoneBook_Base.DO_State)o1.get$obj$state(false)).root;
        }
        @Override
        public void setValue(pt.tecnico.phonebook.domain.PhoneBook o1, pt.ist.fenixframework.DomainRoot o2) {
            ((PhoneBook_Base.DO_State)o1.get$obj$state(true)).root = o2;
        }
        public pt.ist.fenixframework.dml.runtime.Role<pt.ist.fenixframework.DomainRoot,pt.tecnico.phonebook.domain.PhoneBook> getInverseRole() {
            return pt.ist.fenixframework.DomainRoot.role$$phonebook;
        }
        
    };
    
    private final static class PhoneBookContainsPersons {
        private static final pt.ist.fenixframework.backend.jvstmojb.pstm.LoggingRelation<pt.tecnico.phonebook.domain.PhoneBook,pt.tecnico.phonebook.domain.Person> relation = new pt.ist.fenixframework.backend.jvstmojb.pstm.LoggingRelation<pt.tecnico.phonebook.domain.PhoneBook,pt.tecnico.phonebook.domain.Person>(role$$person, "PhoneBookContainsPersons");
    }
    public static pt.ist.fenixframework.dml.runtime.DirectRelation<pt.tecnico.phonebook.domain.PhoneBook,pt.tecnico.phonebook.domain.Person> getRelationPhoneBookContainsPersons() {
        return PhoneBookContainsPersons.relation;
    }
    
    static {
        PhoneBookContainsPersons.relation.setRelationName("pt.tecnico.phonebook.domain.PhoneBook.PhoneBookContainsPersons");
    }
    private static pt.ist.fenixframework.dml.runtime.KeyFunction<Comparable<?>,pt.tecnico.phonebook.domain.Person> keyFunction$$person = new pt.ist.fenixframework.dml.runtime.KeyFunction<Comparable<?>,pt.tecnico.phonebook.domain.Person>() { public Comparable<?> getKey(pt.tecnico.phonebook.domain.Person value) { return value.getOid(); } public boolean allowMultipleKeys() {return false; }};
    
    public static pt.ist.fenixframework.dml.runtime.DirectRelation<pt.ist.fenixframework.DomainRoot,pt.tecnico.phonebook.domain.PhoneBook> getRelationDomainRootHasPhoneBookApplication() {
        return pt.ist.fenixframework.DomainRoot.getRelationDomainRootHasPhoneBookApplication();
    }
    
    // Slots
    
    // Role Slots
    private RelationList<pt.tecnico.phonebook.domain.PhoneBook,pt.tecnico.phonebook.domain.Person> get$rl$person() {
        return get$$relationList("person", getRelationPhoneBookContainsPersons());
        
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
    protected  PhoneBook_Base() {
        super();
    }
    
    // Getters and Setters
    
    // Role Methods
    
    public void addPerson(pt.tecnico.phonebook.domain.Person person) {
        getRelationPhoneBookContainsPersons().add((pt.tecnico.phonebook.domain.PhoneBook)this, person);
    }
    
    public void removePerson(pt.tecnico.phonebook.domain.Person person) {
        getRelationPhoneBookContainsPersons().remove((pt.tecnico.phonebook.domain.PhoneBook)this, person);
    }
    
    public java.util.Set<pt.tecnico.phonebook.domain.Person> getPersonSet() {
        return get$rl$person();
    }
    
    public void set$person(OJBFunctionalSetWrapper person) {
        get$rl$person().setFromOJB(this, "person", person);
    }
    
    @Deprecated
    public java.util.Set<pt.tecnico.phonebook.domain.Person> getPerson() {
        return getPersonSet();
    }
    
    @Deprecated
    public int getPersonCount() {
        return getPersonSet().size();
    }
    
    public pt.ist.fenixframework.DomainRoot getRoot() {
        return ((DO_State)this.get$obj$state(false)).root;
    }
    
    public void setRoot(pt.ist.fenixframework.DomainRoot root) {
        getRelationDomainRootHasPhoneBookApplication().add(root, (pt.tecnico.phonebook.domain.PhoneBook)this);
    }
    
    private java.lang.Long get$oidRoot() {
        pt.ist.fenixframework.backend.jvstmojb.pstm.AbstractDomainObject value = (pt.ist.fenixframework.backend.jvstmojb.pstm.AbstractDomainObject) ((DO_State)this.get$obj$state(false)).root;
        return (value == null) ? null : value.getOid();
    }
    
    
    protected void checkDisconnected() {
        DO_State castedState = (DO_State)this.get$obj$state(false);
        if (get$rl$person().size() > 0) handleAttemptToDeleteConnectedObject("Person");
        if (castedState.root != null) handleAttemptToDeleteConnectedObject("Root");
        
    }
    
    protected void readStateFromResultSet(java.sql.ResultSet rs, pt.ist.fenixframework.backend.jvstmojb.pstm.OneBoxDomainObject.DO_State  state) throws java.sql.SQLException {
        DO_State castedState = (DO_State)state;
        castedState.root = pt.ist.fenixframework.backend.jvstmojb.repository.ResultSetReader.readDomainObject(rs, "OID_ROOT");
    }
    protected pt.ist.fenixframework.dml.runtime.Relation get$$relationFor(String attrName) {
        if (attrName.equals("person")) return getRelationPhoneBookContainsPersons();
        return super.get$$relationFor(attrName);
        
    }
    protected pt.ist.fenixframework.backend.jvstmojb.pstm.OneBoxDomainObject.DO_State  make$newState() {
        return new DO_State();
        
    }
    protected void create$allLists() {
        super.create$allLists();
        get$$relationList("person", getRelationPhoneBookContainsPersons());
        
    }
    protected static class DO_State extends pt.ist.fenixframework.backend.jvstmojb.pstm.OneBoxDomainObject.DO_State {
        private pt.ist.fenixframework.DomainRoot root;
        protected void copyTo(pt.ist.fenixframework.backend.jvstmojb.pstm.OneBoxDomainObject.DO_State  newState) {
            super.copyTo(newState);
            DO_State newCasted = (DO_State)newState;
            newCasted.root = this.root;
            
        }
        
    }
    
}
