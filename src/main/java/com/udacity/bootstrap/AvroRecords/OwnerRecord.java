/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.udacity.bootstrap.AvroRecords;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class OwnerRecord extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 8368339717077957543L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Owner\",\"namespace\":\"com.udacity.bootstrap\",\"fields\":[{\"name\":\"id\",\"type\":\"long\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"age\",\"type\":\"int\"},{\"name\":\"dogs\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"DogRecord\",\"fields\":[{\"name\":\"id\",\"type\":\"long\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"breed\",\"type\":\"string\"},{\"name\":\"origin\",\"type\":\"string\"},{\"name\":\"fk_owner_id\",\"type\":\"long\"}]}},\"default\":[]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<OwnerRecord> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<OwnerRecord> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<OwnerRecord> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<OwnerRecord> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<OwnerRecord> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Owner to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Owner from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Owner instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static OwnerRecord fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private long id;
  private java.lang.CharSequence name;
  private int age;
  private java.util.List<DogRecord> dogs;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public OwnerRecord() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param name The new value for name
   * @param age The new value for age
   * @param dogs The new value for dogs
   */
  public OwnerRecord(java.lang.Long id, java.lang.CharSequence name, java.lang.Integer age, java.util.List<DogRecord> dogs) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.dogs = dogs;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return name;
    case 2: return age;
    case 3: return dogs;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Long)value$; break;
    case 1: name = (java.lang.CharSequence)value$; break;
    case 2: age = (java.lang.Integer)value$; break;
    case 3: dogs = (java.util.List<DogRecord>)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public long getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(long value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'age' field.
   * @return The value of the 'age' field.
   */
  public int getAge() {
    return age;
  }


  /**
   * Sets the value of the 'age' field.
   * @param value the value to set.
   */
  public void setAge(int value) {
    this.age = value;
  }

  /**
   * Gets the value of the 'dogs' field.
   * @return The value of the 'dogs' field.
   */
  public java.util.List<DogRecord> getDogs() {
    return dogs;
  }


  /**
   * Sets the value of the 'dogs' field.
   * @param value the value to set.
   */
  public void setDogs(java.util.List<DogRecord> value) {
    this.dogs = value;
  }

  /**
   * Creates a new Owner RecordBuilder.
   * @return A new Owner RecordBuilder
   */
  public static OwnerRecord.Builder newBuilder() {
    return new OwnerRecord.Builder();
  }

  /**
   * Creates a new Owner RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Owner RecordBuilder
   */
  public static OwnerRecord.Builder newBuilder(OwnerRecord.Builder other) {
    if (other == null) {
      return new OwnerRecord.Builder();
    } else {
      return new OwnerRecord.Builder(other);
    }
  }

  /**
   * Creates a new Owner RecordBuilder by copying an existing Owner instance.
   * @param other The existing instance to copy.
   * @return A new Owner RecordBuilder
   */
  public static OwnerRecord.Builder newBuilder(OwnerRecord other) {
    if (other == null) {
      return new OwnerRecord.Builder();
    } else {
      return new OwnerRecord.Builder(other);
    }
  }

  /**
   * RecordBuilder for Owner instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OwnerRecord>
    implements org.apache.avro.data.RecordBuilder<OwnerRecord> {

    private long id;
    private java.lang.CharSequence name;
    private int age;
    private java.util.List<DogRecord> dogs;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(OwnerRecord.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.age)) {
        this.age = data().deepCopy(fields()[2].schema(), other.age);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.dogs)) {
        this.dogs = data().deepCopy(fields()[3].schema(), other.dogs);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing Owner instance
     * @param other The existing instance to copy.
     */
    private Builder(OwnerRecord other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.age)) {
        this.age = data().deepCopy(fields()[2].schema(), other.age);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.dogs)) {
        this.dogs = data().deepCopy(fields()[3].schema(), other.dogs);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public long getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public OwnerRecord.Builder setId(long value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public OwnerRecord.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public OwnerRecord.Builder setName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public OwnerRecord.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'age' field.
      * @return The value.
      */
    public int getAge() {
      return age;
    }


    /**
      * Sets the value of the 'age' field.
      * @param value The value of 'age'.
      * @return This builder.
      */
    public OwnerRecord.Builder setAge(int value) {
      validate(fields()[2], value);
      this.age = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'age' field has been set.
      * @return True if the 'age' field has been set, false otherwise.
      */
    public boolean hasAge() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'age' field.
      * @return This builder.
      */
    public OwnerRecord.Builder clearAge() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'dogs' field.
      * @return The value.
      */
    public java.util.List<DogRecord> getDogs() {
      return dogs;
    }


    /**
      * Sets the value of the 'dogs' field.
      * @param value The value of 'dogs'.
      * @return This builder.
      */
    public OwnerRecord.Builder setDogs(java.util.List<DogRecord> value) {
      validate(fields()[3], value);
      this.dogs = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'dogs' field has been set.
      * @return True if the 'dogs' field has been set, false otherwise.
      */
    public boolean hasDogs() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'dogs' field.
      * @return This builder.
      */
    public OwnerRecord.Builder clearDogs() {
      dogs = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public OwnerRecord build() {
      try {
        OwnerRecord record = new OwnerRecord();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Long) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.age = fieldSetFlags()[2] ? this.age : (java.lang.Integer) defaultValue(fields()[2]);
        record.dogs = fieldSetFlags()[3] ? this.dogs : (java.util.List<DogRecord>) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<OwnerRecord>
    WRITER$ = (org.apache.avro.io.DatumWriter<OwnerRecord>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<OwnerRecord>
    READER$ = (org.apache.avro.io.DatumReader<OwnerRecord>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeLong(this.id);

    out.writeString(this.name);

    out.writeInt(this.age);

    long size0 = this.dogs.size();
    out.writeArrayStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (DogRecord e0: this.dogs) {
      actualSize0++;
      out.startItem();
      e0.customEncode(out);
    }
    out.writeArrayEnd();
    if (actualSize0 != size0)
      throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readLong();

      this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);

      this.age = in.readInt();

      long size0 = in.readArrayStart();
      java.util.List<DogRecord> a0 = this.dogs;
      if (a0 == null) {
        a0 = new SpecificData.Array<DogRecord>((int)size0, SCHEMA$.getField("dogs").schema());
        this.dogs = a0;
      } else a0.clear();
      SpecificData.Array<DogRecord> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<DogRecord>)a0 : null);
      for ( ; 0 < size0; size0 = in.arrayNext()) {
        for ( ; size0 != 0; size0--) {
          DogRecord e0 = (ga0 != null ? ga0.peek() : null);
          if (e0 == null) {
            e0 = new DogRecord();
          }
          e0.customDecode(in);
          a0.add(e0);
        }
      }

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readLong();
          break;

        case 1:
          this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
          break;

        case 2:
          this.age = in.readInt();
          break;

        case 3:
          long size0 = in.readArrayStart();
          java.util.List<DogRecord> a0 = this.dogs;
          if (a0 == null) {
            a0 = new SpecificData.Array<DogRecord>((int)size0, SCHEMA$.getField("dogs").schema());
            this.dogs = a0;
          } else a0.clear();
          SpecificData.Array<DogRecord> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<DogRecord>)a0 : null);
          for ( ; 0 < size0; size0 = in.arrayNext()) {
            for ( ; size0 != 0; size0--) {
              DogRecord e0 = (ga0 != null ? ga0.peek() : null);
              if (e0 == null) {
                e0 = new DogRecord();
              }
              e0.customDecode(in);
              a0.add(e0);
            }
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










