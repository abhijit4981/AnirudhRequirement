import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DeleteuserComponent } from './components/deleteuser/deleteuser.component';
import { RegisterComponent } from './components/register/register.component';
import { UpdateuserComponent } from './components/updateuser/updateuser.component';
import { ViewusersComponent } from './components/viewusers/viewusers.component';

const routes: Routes = [
  { path: 'register-component', component: RegisterComponent },
  { path: 'viewuser-component', component: ViewusersComponent },
  {path: "deletemodel/:id", component: DeleteuserComponent},
  {path: "updatemodel/:id", component: UpdateuserComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
