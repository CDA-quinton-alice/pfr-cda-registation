import { AgendaComponent } from '../modules/evenement/agenda/agenda.component';
import { Ievent } from './ievent';

export interface IEditData {
    event: Ievent;
    ac?:AgendaComponent;
    date?:Date;
}
