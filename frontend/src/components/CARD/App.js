import React from "react";
import Card from "./Card";
import "./styles.css";

const details = () =>
  "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.".substring(
    0,
    Math.floor(Math.random() * 1000)
  );

const tableData = [
  {
    id: 1,
    name: "item 1",
    details: details(),
    movieID: 1,
    rating: 5
  },
  {
    id: 2,
    name: "item 2",
    details: details(),
    movieID: 2,
    rating: 2
  },
  { id: 3, name: "item 3", details: details(), movieID: 3, rating: 5 },
  { id: 4, name: "item 4", details: details(), movieID: 4, rating: 5 },
  { id: 5, name: "item 4", details: details(), movieID: 4, rating: 5 },
  { id: 6, name: "item 4", details: details(), movieID: 4, rating: 5 }
];

export default function App() {
  return (
    <div className="card-list">
      {tableData.map(item => (
        <Card item={item} key={item.id} />
      ))}
    </div>
  );
}
