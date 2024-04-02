
package biodata.model;

/**
 *  * @author Balbali
 *  * @version  1.5
 *  * @since 1.0
 * classe utilisateur
 */
public class User {

    private String id;

    private String email;

    private String dob;

    private String gender;

    private String lastname;

    private String firstname;

    public String getId ()
    {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId (String id)
    {
        this.id = id;
    }

    /**
     *
     * @return retouner un email
     */
    public String getEmail ()
    {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail (String email)
    {
        this.email = email;
    }

    /**
     *
     * @return retourner la date de naissance
     */
    public String getDob ()
    {
        return dob;
    }

    public void setDob (String dob)
    {
        this.dob = dob;
    }

    /**
     *
     * @return
     */
    public String getGender ()
    {
        return gender;
    }

    /**
     *
     * @param gender
     */
    public void setGender (String gender)
    {
        this.gender = gender;
    }

    /**
     *
     * @return
     */
    public String getLastname ()
    {
        return lastname;
    }

    /**
     *
     * @param lastname
     */
    public void setLastname (String lastname)
    {
        this.lastname = lastname;
    }

    /**
     *
     * @return
     */
    public String getFirstname ()
    {
        return firstname;
    }

    /**
     *
     * @param firstname
     */
    public void setFirstname (String firstname)
    {
        this.firstname = firstname;
    }

    /**
     *
     * @return retoune les informations concernant un utilisateur
     */
    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", email = "+email+", Date de naissance = "+dob+", Statut = "+gender+", Nom = "+lastname+", Prénom = "+firstname+"]";
    }
}