# END POINTS :

http://localhost:8081/theater/restCategory/... << @RepositoryRestResource
  
http://localhost:8081/theater/api/actorimage/upload  << file post
http://localhost:8081/theater/api/actorimage/get/info/:id << get
http://localhost:8081/theater/api/actorimage/load/:id << get
http://localhost:8081/theater/api/actorimage/delete << delete
http://localhost:8081/theater/api/actorimage/update << file put
  
http://localhost:8081/theater/api/playimage/upload  << file post
http://localhost:8081/theater/api/playimage/get/info/:id << get
http://localhost:8081/theater/api/playimage/load/:id << get
http://localhost:8081/theater/api/playimage/delete << delete
http://localhost:8081/theater/api/playimage/update << file put

http://localhost:8081/theater/api/actor/all << get
http://localhost:8081/theater/api/actor/getbyid/:id << get
http://localhost:8081/theater/api/actor/addactor << post
http://localhost:8081/theater/api/actor/updateactor << put
http://localhost:8081/theater/api/actor/deleteactor/:id << delete
http://localhost:8081/theater/api/actor/nameactorscontains/:nameActor << get

http://localhost:8081/theater/api/play/all << get
http://localhost:8081/theater/api/play/getbyid/:id << get
http://localhost:8081/theater/api/play/addplay << post
http://localhost:8081/theater/api/play/updateplay << put
http://localhost:8081/theater/api/play/deleteplay/:id << delete
http://localhost:8081/theater/api/play/titleplayscontains/:nameplay << get
http://localhost:8081/theater/api/play/playsbycat/:idCategory << get



# ENTITIES STRUCTURE :

public class Category {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategory;
	private String titleCategory;
	private String descriptionCategory;
	@JsonIgnore @OneToMany(mappedBy = "category")
	private List<Play> plays;
}
public class Actor {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idActor;
	private String nameActor;
	private String biographyActor;
	 @OneToOne
	 private ActorImage image;
	 private String imagePath;
	@JsonIgnore @ManyToMany @JoinTable (
			name = "plays_actors", joinColumns = @JoinColumn (name = "idActor"),
			inverseJoinColumns = @JoinColumn (name = "idPlay")
	)
	private List<Play> plays;
}
public class Play {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlay;
	private String titlePlay;
	private String subjectPlay;
	private String biographyPlay;
	private Long ticketsNumPlay;
	private Date datePlay;
	private Double pricePlay;
	@ManyToOne
	private Category category;
	@OneToOne
	private PlayImage image;
	private String imagePath;
	@ManyToMany @JoinTable (
			name = "plays_actors", joinColumns = @JoinColumn (name = "idPlay"),
			inverseJoinColumns = @JoinColumn (name = "idActor")
	)
	private List<Actor> actors;
}
public class PlayImage {
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idImage ;
 private String name ;
 private String type ;
 @Column( name = "IMAGE" , length = 4048576 ) @Lob
 private byte[] image; 
 @OneToOne
 private Play play;
}
public class ActorImage {
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idImage ;
 private String name ;
 private String type ;
 @Column( name = "IMAGE" , length = 4048576 ) @Lob
 private byte[] image; 
 @OneToOne
 private Actor actor;
}

  
