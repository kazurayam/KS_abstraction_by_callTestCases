```mermaid
sequenceDiagram
  A ->> B: Query
  B ->> C: Forward Query
  Note right of C: Thinking...
  C --> B: Response
  B --> A: Forward response
```