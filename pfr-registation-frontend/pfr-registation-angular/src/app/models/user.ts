export class User {
    matricule: string;
    nom: string;
    prenom: string;
    dateDeNaissance: Date;
    mail: string;
    tel: string;
    responsable: boolean;
    password: string;
    
    constructor(matricule?: string, nom?: string, prenom?: string, tel?: string, dateDeNaissance?: Date, mail?: string, responsable?: boolean) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.mail = mail;
        this.tel = tel;
        this.responsable = responsable;

    }
}
