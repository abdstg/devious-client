import java.util.ArrayList;
import java.util.BitSet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mu")
@Implements("MusicPatch")
public class MusicPatch extends Node {
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 355822601
	)
	int field3645;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "[Lck;"
	)
	@Export("rawSounds")
	class53[] rawSounds;
	@ObfuscatedName("az")
	short[] field3647;
	@ObfuscatedName("af")
	byte[] field3648;
	@ObfuscatedName("aa")
	byte[] field3653;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "[Lms;"
	)
	MusicPatchNode2[] field3649;
	@ObfuscatedName("ab")
	byte[] field3651;
	@ObfuscatedName("ac")
	ArrayList field3652;
	@ObfuscatedName("ao")
	int[] field3650;

	MusicPatch(byte[] var1) {
		this.field3652 = new ArrayList(8);
		this.rawSounds = new class53[128];
		this.field3647 = new short[128];
		this.field3648 = new byte[128];
		this.field3653 = new byte[128];
		this.field3649 = new MusicPatchNode2[128];
		this.field3651 = new byte[128];
		this.field3650 = new int[128];
		Buffer var2 = new Buffer(var1);

		int var3;
		for (var3 = 0; var2.array[var3 + var2.offset] != 0; ++var3) {
		}

		byte[] var4 = new byte[var3];

		int var5;
		for (var5 = 0; var5 < var3; ++var5) {
			var4[var5] = var2.readByte();
		}

		++var2.offset;
		++var3;
		var5 = var2.offset;
		var2.offset += var3;

		int var6;
		for (var6 = 0; var2.array[var6 + var2.offset] != 0; ++var6) {
		}

		byte[] var7 = new byte[var6];

		int var8;
		for (var8 = 0; var8 < var6; ++var8) {
			var7[var8] = var2.readByte();
		}

		++var2.offset;
		++var6;
		var8 = var2.offset;
		var2.offset += var6;

		int var9;
		for (var9 = 0; var2.array[var9 + var2.offset] != 0; ++var9) {
		}

		byte[] var10 = new byte[var9];

		for (int var11 = 0; var11 < var9; ++var11) {
			var10[var11] = var2.readByte();
		}

		++var2.offset;
		++var9;
		byte[] var36 = new byte[var9];
		int var12;
		int var14;
		if (var9 > 1) {
			var36[1] = 1;
			int var13 = 1;
			var12 = 2;

			for (var14 = 2; var14 < var9; ++var14) {
				int var41 = var2.readUnsignedByte();
				if (var41 == 0) {
					var13 = var12++;
				} else {
					if (var41 <= var13) {
						--var41;
					}

					var13 = var41;
				}

				var36[var14] = (byte)var13;
			}
		} else {
			var12 = var9;
		}

		MusicPatchNode2[] var37 = new MusicPatchNode2[var12];

		MusicPatchNode2 var15;
		for (var14 = 0; var14 < var37.length; ++var14) {
			var15 = var37[var14] = new MusicPatchNode2();
			int var40 = var2.readUnsignedByte();
			if (var40 > 0) {
				var15.field3570 = new byte[var40 * 2];
			}

			var40 = var2.readUnsignedByte();
			if (var40 > 0) {
				var15.field3567 = new byte[var40 * 2 + 2];
				var15.field3567[1] = 64;
			}
		}

		var14 = var2.readUnsignedByte();
		byte[] var42 = var14 > 0 ? new byte[var14 * 2] : null;
		var14 = var2.readUnsignedByte();
		byte[] var16 = var14 > 0 ? new byte[var14 * 2] : null;

		int var17;
		for (var17 = 0; var2.array[var17 + var2.offset] != 0; ++var17) {
		}

		byte[] var18 = new byte[var17];

		int var19;
		for (var19 = 0; var19 < var17; ++var19) {
			var18[var19] = var2.readByte();
		}

		++var2.offset;
		++var17;
		var19 = 0;

		int var20;
		for (var20 = 0; var20 < 128; ++var20) {
			var19 += var2.readUnsignedByte();
			this.field3647[var20] = (short)var19;
		}

		var19 = 0;

		short[] var48;
		for (var20 = 0; var20 < 128; ++var20) {
			var19 += var2.readUnsignedByte();
			var48 = this.field3647;
			var48[var20] = (short)(var48[var20] + (var19 << 8));
		}

		var20 = 0;
		int var21 = 0;
		int var22 = 0;

		int var23;
		for (var23 = 0; var23 < 128; ++var23) {
			if (var20 == 0) {
				if (var21 < var18.length) {
					var20 = var18[var21++];
				} else {
					var20 = -1;
				}

				var22 = var2.readVarInt();
			}

			var48 = this.field3647;
			var48[var23] = (short)(var48[var23] + ((var22 - 1 & 2) << 14));
			this.field3650[var23] = var22;
			--var20;
		}

		var20 = 0;
		var21 = 0;
		var23 = 0;

		int var24;
		for (var24 = 0; var24 < 128; ++var24) {
			if (this.field3650[var24] != 0) {
				if (var20 == 0) {
					if (var21 < var4.length) {
						var20 = var4[var21++];
					} else {
						var20 = -1;
					}

					var23 = var2.array[var5++] - 1;
				}

				this.field3651[var24] = (byte)var23;
				--var20;
			}
		}

		var20 = 0;
		var21 = 0;
		var24 = 0;

		for (int var25 = 0; var25 < 128; ++var25) {
			if (this.field3650[var25] != 0) {
				if (var20 == 0) {
					if (var21 < var7.length) {
						var20 = var7[var21++];
					} else {
						var20 = -1;
					}

					var24 = var2.array[var8++] + 16 << 2;
				}

				this.field3653[var25] = (byte)var24;
				--var20;
			}
		}

		var20 = 0;
		var21 = 0;
		MusicPatchNode2 var38 = null;

		int var26;
		for (var26 = 0; var26 < 128; ++var26) {
			if (this.field3650[var26] != 0) {
				if (var20 == 0) {
					var38 = var37[var36[var21]];
					if (var21 < var10.length) {
						var20 = var10[var21++];
					} else {
						var20 = -1;
					}
				}

				this.field3649[var26] = var38;
				--var20;
			}
		}

		var20 = 0;
		var21 = 0;
		var26 = 0;

		int var27;
		for (var27 = 0; var27 < 128; ++var27) {
			if (var20 == 0) {
				if (var21 < var18.length) {
					var20 = var18[var21++];
				} else {
					var20 = -1;
				}

				if (this.field3650[var27] > 0) {
					var26 = var2.readUnsignedByte() + 1;
				}
			}

			this.field3648[var27] = (byte)var26;
			--var20;
		}

		this.field3645 = var2.readUnsignedByte() + 1;

		int var29;
		MusicPatchNode2 var39;
		for (var27 = 0; var27 < var12; ++var27) {
			var39 = var37[var27];
			if (var39.field3570 != null) {
				for (var29 = 1; var29 < var39.field3570.length; var29 += 2) {
					var39.field3570[var29] = var2.readByte();
				}
			}

			if (var39.field3567 != null) {
				for (var29 = 3; var29 < var39.field3567.length - 2; var29 += 2) {
					var39.field3567[var29] = var2.readByte();
				}
			}
		}

		if (var42 != null) {
			for (var27 = 1; var27 < var42.length; var27 += 2) {
				var42[var27] = var2.readByte();
			}
		}

		if (var16 != null) {
			for (var27 = 1; var27 < var16.length; var27 += 2) {
				var16[var27] = var2.readByte();
			}
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var39 = var37[var27];
			if (var39.field3567 != null) {
				var19 = 0;

				for (var29 = 2; var29 < var39.field3567.length; var29 += 2) {
					var19 = 1 + var19 + var2.readUnsignedByte();
					var39.field3567[var29] = (byte)var19;
				}
			}
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var39 = var37[var27];
			if (var39.field3570 != null) {
				var19 = 0;

				for (var29 = 2; var29 < var39.field3570.length; var29 += 2) {
					var19 = var19 + 1 + var2.readUnsignedByte();
					var39.field3570[var29] = (byte)var19;
				}
			}
		}

		byte var30;
		int var32;
		int var33;
		int var34;
		int var45;
		byte var47;
		if (var42 != null) {
			var19 = var2.readUnsignedByte();
			var42[0] = (byte)var19;

			for (var27 = 2; var27 < var42.length; var27 += 2) {
				var19 = 1 + var19 + var2.readUnsignedByte();
				var42[var27] = (byte)var19;
			}

			var47 = var42[0];
			byte var28 = var42[1];

			for (var29 = 0; var29 < var47; ++var29) {
				this.field3648[var29] = (byte)(var28 * this.field3648[var29] + 32 >> 6);
			}

			for (var29 = 2; var29 < var42.length; var29 += 2) {
				var30 = var42[var29];
				byte var31 = var42[var29 + 1];
				var32 = var28 * (var30 - var47) + (var30 - var47) / 2;

				for (var33 = var47; var33 < var30; ++var33) {
					var34 = HealthBarUpdate.method2468(var32, var30 - var47);
					this.field3648[var33] = (byte)(var34 * this.field3648[var33] + 32 >> 6);
					var32 += var31 - var28;
				}

				var47 = var30;
				var28 = var31;
			}

			for (var45 = var47; var45 < 128; ++var45) {
				this.field3648[var45] = (byte)(var28 * this.field3648[var45] + 32 >> 6);
			}

			var15 = null;
		}

		if (var16 != null) {
			var19 = var2.readUnsignedByte();
			var16[0] = (byte)var19;

			for (var27 = 2; var27 < var16.length; var27 += 2) {
				var19 = var19 + 1 + var2.readUnsignedByte();
				var16[var27] = (byte)var19;
			}

			var47 = var16[0];
			int var44 = var16[1] << 1;

			for (var29 = 0; var29 < var47; ++var29) {
				var45 = var44 + (this.field3653[var29] & 255);
				if (var45 < 0) {
					var45 = 0;
				}

				if (var45 > 128) {
					var45 = 128;
				}

				this.field3653[var29] = (byte)var45;
			}

			int var46;
			for (var29 = 2; var29 < var16.length; var29 += 2) {
				var30 = var16[var29];
				var46 = var16[var29 + 1] << 1;
				var32 = var44 * (var30 - var47) + (var30 - var47) / 2;

				for (var33 = var47; var33 < var30; ++var33) {
					var34 = HealthBarUpdate.method2468(var32, var30 - var47);
					int var35 = var34 + (this.field3653[var33] & 255);
					if (var35 < 0) {
						var35 = 0;
					}

					if (var35 > 128) {
						var35 = 128;
					}

					this.field3653[var33] = (byte)var35;
					var32 += var46 - var44;
				}

				var47 = var30;
				var44 = var46;
			}

			for (var45 = var47; var45 < 128; ++var45) {
				var46 = var44 + (this.field3653[var45] & 255);
				if (var46 < 0) {
					var46 = 0;
				}

				if (var46 > 128) {
					var46 = 128;
				}

				this.field3653[var45] = (byte)var46;
			}

			Object var43 = null;
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var37[var27].field3568 = var2.readUnsignedByte();
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var39 = var37[var27];
			if (var39.field3570 != null) {
				var39.field3569 = var2.readUnsignedByte();
			}

			if (var39.field3567 != null) {
				var39.field3571 = var2.readUnsignedByte();
			}

			if (var39.field3568 > 0) {
				var39.field3574 = var2.readUnsignedByte();
			}
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var37[var27].field3573 = var2.readUnsignedByte();
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var39 = var37[var27];
			if (var39.field3573 > 0) {
				var39.field3572 = var2.readUnsignedByte();
			}
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var39 = var37[var27];
			if (var39.field3572 > 0) {
				var39.field3566 = var2.readUnsignedByte();
			}
		}

	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Lbq;Ljava/util/BitSet;I)Z",
		garbageValue = "1919455999"
	)
	boolean method6436(SoundCache var1, BitSet var2) {
		boolean var3 = true;
		int var4 = 0;
		class53 var5 = new class53();

		int var7;
		for (int var6 = var2.nextSetBit(0); var6 != -1; var6 = var2.nextSetBit(var7)) {
			var7 = var2.nextClearBit(var6);

			for (int var8 = var6; var8 < var7; ++var8) {
				if (var2.get(var8)) {
					int var9 = this.field3650[var8];
					if (var9 != 0) {
						if (var9 != var4) {
							var4 = var9--;
							if ((var9 & 1) == 0) {
								var5 = new class53(var1.method875(var9 >> 2));
							} else {
								var5 = var1.method862(var9 >> 2);
							}

							if (var5.method1073()) {
								var3 = false;
							} else {
								this.field3652.add(this.field3652.size(), var5);
							}
						}

						if (!var5.method1073()) {
							this.rawSounds[var8] = var5;
							this.field3650[var8] = 0;
						}
					}
				}
			}
		}

		return var3;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "630964372"
	)
	void method6437() {
		this.field3650 = null;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(Ldt;IIIIIIIILir;B)V",
		garbageValue = "83"
	)
	static final void method6441(WorldView var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, CollisionMap var9) {
		ObjectComposition var10 = HitSplatDefinition.getObjectDefinition(var5);
		int var11 = var8 >= 0 ? var8 : var10.animationId;
		int var12;
		int var13;
		if (var6 != 1 && var6 != 3) {
			var12 = var10.sizeX;
			var13 = var10.sizeY;
		} else {
			var12 = var10.sizeY;
			var13 = var10.sizeX;
		}

		int var14;
		int var15;
		if (var3 + var12 <= var0.sizeX) {
			var14 = var3 + (var12 >> 1);
			var15 = var3 + (var12 + 1 >> 1);
		} else {
			var14 = var3;
			var15 = var3 + 1;
		}

		int var16;
		int var17;
		if (var13 + var4 <= var0.sizeY) {
			var16 = (var13 >> 1) + var4;
			var17 = (var13 + 1 >> 1) + var4;
		} else {
			var16 = var4;
			var17 = var4 + 1;
		}

		int[][] var18 = var0.tileHeights[var2];
		int var19 = var18[var15][var17] + var18[var14][var16] + var18[var15][var16] + var18[var14][var17] >> 2;
		int var20 = (var3 << 7) + (var12 << 6);
		int var21 = (var4 << 7) + (var13 << 6);
		Scene var22 = var0.scene;
		long var23 = KitDefinition.calculateTag(var3, var4, 2, var10.int1 == 0, var5, var0.id);
		int var25 = (var6 << 6) + var7;
		if (var10.int3 == 1) {
			var25 += 256;
		}

		Object var33;
		if (var7 == 22) {
			if (var11 == -1 && var10.transforms == null) {
				var33 = var10.getModel(22, var6, var18, var20, var19, var21);
			} else {
				var33 = new DynamicObject(var0, var5, 22, var6, var2, var3, var4, var11, var10.boolean3, (Renderable)null);
			}

			var22.newFloorDecoration(var1, var3, var4, var19, (Renderable)var33, var23, var25);
			if (var10.interactType == 1 && var9 != null) {
				var9.setBlockedByFloorDec(var3, var4);
			}

		} else if (var7 != 10 && var7 != 11) {
			if (var7 >= 12) {
				if (var11 == -1 && var10.transforms == null) {
					var33 = var10.getModel(var7, var6, var18, var20, var19, var21);
				} else {
					var33 = new DynamicObject(var0, var5, var7, var6, var2, var3, var4, var11, var10.boolean3, (Renderable)null);
				}

				var22.method4861(var1, var3, var4, var19, 1, 1, (Renderable)var33, 0, var23, var25);
				if (var10.interactType != 0 && var9 != null) {
					var9.addGameObject(var3, var4, var12, var13, var10.boolean1);
				}

			} else if (var7 == 0) {
				if (var11 == -1 && var10.transforms == null) {
					var33 = var10.getModel(0, var6, var18, var20, var19, var21);
				} else {
					var33 = new DynamicObject(var0, var5, 0, var6, var2, var3, var4, var11, var10.boolean3, (Renderable)null);
				}

				var22.newBoundaryObject(var1, var3, var4, var19, (Renderable)var33, (Renderable)null, Tiles.field1059[var6], 0, var23, var25);
				if (var10.interactType != 0 && var9 != null) {
					var9.method4457(var3, var4, var7, var6, var10.boolean1);
				}

			} else if (var7 == 1) {
				if (var11 == -1 && var10.transforms == null) {
					var33 = var10.getModel(1, var6, var18, var20, var19, var21);
				} else {
					var33 = new DynamicObject(var0, var5, 1, var6, var2, var3, var4, var11, var10.boolean3, (Renderable)null);
				}

				var22.newBoundaryObject(var1, var3, var4, var19, (Renderable)var33, (Renderable)null, Tiles.field1047[var6], 0, var23, var25);
				if (var10.interactType != 0 && var9 != null) {
					var9.method4457(var3, var4, var7, var6, var10.boolean1);
				}

			} else {
				int var26;
				if (var7 == 2) {
					var26 = var6 + 1 & 3;
					Object var28;
					Object var34;
					if (var11 == -1 && var10.transforms == null) {
						var34 = var10.getModel(2, var6 + 4, var18, var20, var19, var21);
						var28 = var10.getModel(2, var26, var18, var20, var19, var21);
					} else {
						var34 = new DynamicObject(var0, var5, 2, var6 + 4, var2, var3, var4, var11, var10.boolean3, (Renderable)null);
						var28 = new DynamicObject(var0, var5, 2, var26, var2, var3, var4, var11, var10.boolean3, (Renderable)null);
					}

					var22.newBoundaryObject(var1, var3, var4, var19, (Renderable)var34, (Renderable)var28, Tiles.field1059[var6], Tiles.field1059[var26], var23, var25);
					if (var10.interactType != 0 && var9 != null) {
						var9.method4457(var3, var4, var7, var6, var10.boolean1);
					}

				} else if (var7 == 3) {
					if (var11 == -1 && var10.transforms == null) {
						var33 = var10.getModel(3, var6, var18, var20, var19, var21);
					} else {
						var33 = new DynamicObject(var0, var5, 3, var6, var2, var3, var4, var11, var10.boolean3, (Renderable)null);
					}

					var22.newBoundaryObject(var1, var3, var4, var19, (Renderable)var33, (Renderable)null, Tiles.field1047[var6], 0, var23, var25);
					if (var10.interactType != 0 && var9 != null) {
						var9.method4457(var3, var4, var7, var6, var10.boolean1);
					}

				} else if (var7 == 9) {
					if (var11 == -1 && var10.transforms == null) {
						var33 = var10.getModel(var7, var6, var18, var20, var19, var21);
					} else {
						var33 = new DynamicObject(var0, var5, var7, var6, var2, var3, var4, var11, var10.boolean3, (Renderable)null);
					}

					var22.method4861(var1, var3, var4, var19, 1, 1, (Renderable)var33, 0, var23, var25);
					if (var10.interactType != 0 && var9 != null) {
						var9.addGameObject(var3, var4, var12, var13, var10.boolean1);
					}

				} else if (var7 == 4) {
					if (var11 == -1 && var10.transforms == null) {
						var33 = var10.getModel(4, var6, var18, var20, var19, var21);
					} else {
						var33 = new DynamicObject(var0, var5, 4, var6, var2, var3, var4, var11, var10.boolean3, (Renderable)null);
					}

					var22.newWallDecoration(var1, var3, var4, var19, (Renderable)var33, (Renderable)null, Tiles.field1059[var6], 0, 0, 0, var23, var25);
				} else {
					long var27;
					Object var29;
					if (var7 == 5) {
						var26 = 16;
						var27 = var22.getBoundaryObjectTag(var1, var3, var4);
						if (0L != var27) {
							var26 = HitSplatDefinition.getObjectDefinition(class105.Entity_unpackID(var27)).int2;
						}

						if (var11 == -1 && var10.transforms == null) {
							var29 = var10.getModel(4, var6, var18, var20, var19, var21);
						} else {
							var29 = new DynamicObject(var0, var5, 4, var6, var2, var3, var4, var11, var10.boolean3, (Renderable)null);
						}

						var22.newWallDecoration(var1, var3, var4, var19, (Renderable)var29, (Renderable)null, Tiles.field1059[var6], 0, Tiles.field1053[var6] * var26, Tiles.field1054[var6] * var26, var23, var25);
					} else if (var7 == 6) {
						var26 = 8;
						var27 = var22.getBoundaryObjectTag(var1, var3, var4);
						if (var27 != 0L) {
							var26 = HitSplatDefinition.getObjectDefinition(class105.Entity_unpackID(var27)).int2 / 2;
						}

						if (var11 == -1 && var10.transforms == null) {
							var29 = var10.getModel(4, var6 + 4, var18, var20, var19, var21);
						} else {
							var29 = new DynamicObject(var0, var5, 4, var6 + 4, var2, var3, var4, var11, var10.boolean3, (Renderable)null);
						}

						var22.newWallDecoration(var1, var3, var4, var19, (Renderable)var29, (Renderable)null, 256, var6, Tiles.field1055[var6] * var26, Tiles.field1056[var6] * var26, var23, var25);
					} else if (var7 == 7) {
						int var32 = var6 + 2 & 3;
						if (var11 == -1 && var10.transforms == null) {
							var33 = var10.getModel(4, var32 + 4, var18, var20, var19, var21);
						} else {
							var33 = new DynamicObject(var0, var5, 4, var32 + 4, var2, var3, var4, var11, var10.boolean3, (Renderable)null);
						}

						var22.newWallDecoration(var1, var3, var4, var19, (Renderable)var33, (Renderable)null, 256, var32, 0, 0, var23, var25);
					} else if (var7 == 8) {
						var26 = 8;
						var27 = var22.getBoundaryObjectTag(var1, var3, var4);
						if (0L != var27) {
							var26 = HitSplatDefinition.getObjectDefinition(class105.Entity_unpackID(var27)).int2 / 2;
						}

						int var31 = var6 + 2 & 3;
						Object var30;
						if (var11 == -1 && var10.transforms == null) {
							var29 = var10.getModel(4, var6 + 4, var18, var20, var19, var21);
							var30 = var10.getModel(4, var31 + 4, var18, var20, var19, var21);
						} else {
							var29 = new DynamicObject(var0, var5, 4, var6 + 4, var2, var3, var4, var11, var10.boolean3, (Renderable)null);
							var30 = new DynamicObject(var0, var5, 4, var31 + 4, var2, var3, var4, var11, var10.boolean3, (Renderable)null);
						}

						var22.newWallDecoration(var1, var3, var4, var19, (Renderable)var29, (Renderable)var30, 256, var6, Tiles.field1055[var6] * var26, Tiles.field1056[var6] * var26, var23, var25);
					}
				}
			}
		} else {
			if (var11 == -1 && var10.transforms == null) {
				var33 = var10.getModel(10, var6, var18, var20, var19, var21);
			} else {
				var33 = new DynamicObject(var0, var5, 10, var6, var2, var3, var4, var11, var10.boolean3, (Renderable)null);
			}

			if (var33 != null) {
				var22.method4861(var1, var3, var4, var19, var12, var13, (Renderable)var33, var7 == 11 ? 256 : 0, var23, var25);
			}

			if (var10.interactType != 0 && var9 != null) {
				var9.addGameObject(var3, var4, var12, var13, var10.boolean1);
			}

		}
	}
}
