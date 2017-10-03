# Technos

1. ~~Define REST provider~~ : Resteasy
2. How to manage images ?
3. User session = JWT


# Concept

1. Define resources
  * Media
    * Book : Comics, Novel ?
    * Video : DVD, BRD ? (VHS? seriously?)
    * Musique : CD, Vinyls (noo, not tape!)
  * User
2. Define REST API
  * Classical GET on  `/resources/[{id}[/subresources/]]`
  * Only one {id} in URL : never more than `resources/{id}/resources`
  * Classical DELETE on `/resources/{id}`
  * `POST /resources/` creates the new resource, and results on a 201 with location "/resources/{id}"
  * `PUT /resources/{id}` replace (~modify) the resource with given id (so, not partial resource in it)
  * `POST /resources/{id}` = partial update ?

